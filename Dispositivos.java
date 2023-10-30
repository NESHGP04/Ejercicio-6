/*Ejercicio #6 POO``
Marinés García 23391
CLASS Padre */

public abstract class Dispositivos {
    protected String id;
    protected String modelo;
    protected int estado_opc;
    protected String tipo;
    protected String marca;

    //Constructor
    public Dispositivos(String id, int estado_opc,String modelo, String marca){
        this.id = id;
        this.modelo = modelo;
        this.estado_opc = estado_opc;
        this.marca = marca;
    }

    //Getters
    public String getId(){
        return this.id;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getEstado(){
        return this.estado_opc;
    }

    public String getTipo(){
        return this.tipo;
    }
}
