package modelo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class cinta {
    ArrayList<String> valoresCinta = new ArrayList<>();
    ArrayList<String> cintaFinal;
    int tamINI;
    int pos;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getTamINI() {
        return tamINI;
    }

    public void setTamINI(int tamINI) {
        this.tamINI = tamINI;
    }
    public ArrayList<String> getValoresCinta() {
        return valoresCinta;
    }
    public void agregarSimbolo(String simbolo){
        valoresCinta.add(simbolo);
    }

    public ArrayList<String> getCintaFinal() {
        return cintaFinal;
    }
    public void setCintaFinal(ArrayList<String> cintaFinal) {
        this.cintaFinal = cintaFinal;
    }
    public  void copiarCinta(){
        this.cintaFinal=this.getValoresCinta();
    }
    public int validar(){
        int respuesta= 0;
        int cantVacios = 0;  
        for (int i = 0; i < cintaFinal.size(); i++) {
            
            if (cintaFinal.get(i).equals("-")) {
                cantVacios++;
            }
        }
        if (cantVacios == tamINI && cintaFinal.get(pos).equals("-")== false) {
            respuesta = 1;
        }else{
            respuesta = 0;
        }
        return respuesta;
    }

}
