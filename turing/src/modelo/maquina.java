package modelo;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class maquina {
    int n, m; // n: cantidad de estados menos el aceptacion(-1),m: numero de simbolos 
    int cantcasos;
    ArrayList<String> alfabeto = new ArrayList<>();
    ArrayList<transicion> ListaFunciones = new ArrayList<>();
    ArrayList<cinta> casos = new ArrayList<>();
    

    public ArrayList<cinta> getCasos() {
        return casos;
    }
    public int getCantcasos() {
        return cantcasos;
    }
    public void setCantcasos(int cantcasos) {
        this.cantcasos = cantcasos;
    }
    public int getN() {
        return n;
    }
    public int getM() {
        return m;
    }
    public void agregaNM(String lineas){
        StringTokenizer separa=new StringTokenizer(lineas," ");
        while(separa.hasMoreTokens()){
            this.n= Integer.parseInt(separa.nextToken());
            this.m= Integer.parseInt(separa.nextToken());
        }
    }
    public void agregaAlfabeto(String lineas1){
        StringTokenizer separa1=new StringTokenizer(lineas1," ");
        while(separa1.hasMoreTokens()){
            alfabeto.add(separa1.nextToken()+"");
        }
    }
    public ArrayList<String> getAlfabeto() {
        return alfabeto;
    }
    public ArrayList<transicion> getListaFunciones() {
        return ListaFunciones;
    }
    public void agregarFuncion(String lineas2) {
        StringTokenizer separa2=new StringTokenizer(lineas2," ");
        int iniEstado, finalEstado;
        char entrada, salida, direccion;
        iniEstado = Integer.parseInt(separa2.nextToken());
        entrada = separa2.nextToken().charAt(0);
        salida = separa2.nextToken().charAt(0);
        direccion = separa2.nextToken().charAt(0);
        finalEstado = Integer.parseInt(separa2.nextToken());
        transicion funcion = new transicion(iniEstado, finalEstado, entrada, salida, direccion);
        ListaFunciones.add(funcion);
    }
    public void agregarCaso(String lineas3){
        cinta casoNuevo = new cinta();
        for (int i = 0; i < lineas3.length(); i++) {
          casoNuevo.agregarSimbolo(""+lineas3.charAt(i));
        }
        casos.add(casoNuevo);
    }
    public transicion buscarFuncion(int estado,char caracter){
        transicion resultado;
        transicion auxFuncion;
        for (int i = 0; i < ListaFunciones.size(); i++) {
            auxFuncion = ListaFunciones.get(i);
            if (auxFuncion.getIniEstado()== estado && auxFuncion.getEntrada() == caracter) {
                return auxFuncion;
            }
        }
        return null;
    }
    
    public void procesarCintas(){
        cinta AuxCinta;
        int estado,posActual,auxEstado; 
        char entrada;
        transicion auxFuncion;
        for (int i = 0; i < casos.size(); i++) {
            AuxCinta = casos.get(i);
            estado = 0;
            posActual = 0;
            AuxCinta.copiarCinta();
            while (estado != -1) {
                casos.get(i).setPos(posActual);
                if (posActual<0) {
                    AuxCinta.getCintaFinal().add(0,"-");
                    posActual = 0;
                }
                entrada = AuxCinta.cintaFinal.get(posActual).charAt(0);
                auxFuncion = buscarFuncion(estado, entrada);
                AuxCinta.cintaFinal.set(posActual, auxFuncion.salida+"");
                auxEstado = estado;
                estado = auxFuncion.getFinalEstado();
                if (auxFuncion.getDireccion()=='d') {
                    posActual++;
                }
                if (auxFuncion.getDireccion()=='i') {
                    posActual--;
                }
                if (posActual>=AuxCinta.getValoresCinta().size()){
                    AuxCinta.getValoresCinta().add("-");
                }                
            }
            casos.get(i).setCintaFinal(AuxCinta.getCintaFinal());
            
        }
    }
}
