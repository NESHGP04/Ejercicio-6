/*Ejercicio #6 POO``
Marinés García 23391
CLASS hija */

public class Telefono extends Dispositivos implements DispElect{

    //Constructor
    public Telefono(String id, int estado_opc, String tipo,String modelo, String marca){
        super(id, estado_opc, modelo, marca);
        this.tipo = "Teléfono";
    }

    //Métodos overraide de DispElect para Teléfono
    
    @Override
    public void encender(){
        System.out.println("La computadora se ha encendido");
    }

    @Override
    public void apagar(){
        System.out.println("La computadora se ha apagado");
    }

}
