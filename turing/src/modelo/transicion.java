package modelo;

public class transicion {
    int iniEstado, finalEstado;
    char entrada, salida, direccion;
   
    //constructor con datos necesarios
    public transicion(int iniEstado, int finalEstado, char entrada, char salidad, char direccion) {
        this.iniEstado = iniEstado;
        this.finalEstado = finalEstado;
        this.entrada = entrada;
        this.salida = salidad;
        this.direccion = direccion;
    }
    public int getIniEstado() {
        return iniEstado;
    }
    public int getFinalEstado() {
        return finalEstado;
    }
    public char getEntrada() {
        return entrada;
    }
    public char getSalidad() {
        return salida;
    }
    public char getDireccion() {
        return direccion;
    }   
}
