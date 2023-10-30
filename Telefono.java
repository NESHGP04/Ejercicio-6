/*Ejercicio #6 POO``
Marinés García 23391
CLASS hija */

public class Telefono extends Dispositivos implements DispElect{
    
    public Telefono(String id, int estado_opc, String tipo,String modelo, String marca){
        super(id, estado_opc, modelo, marca);
        this.tipo = "Teléfono";
    }

    @Override
    public void encender(){
        System.out.println("La computadora se ha encendido");
    //     if (this.estadoOpc == 0) {
    //         System.out.println("La computadora se ha encendido");
    //         this.estadoOpc = 1;
    //         } else{
    //             System.out.println("Ya la computadora estaba encendida");
    //             }
    }

    @Override
    public void apagar(){
        System.out.println("La computadora se ha apagado");
            // if (this.estadoOpc == 1) {
            //         System.out.println("La computadora se ha apagado");
            //         this.estadoOpc = 0;
            //     }else{
            //     System.out.println("Ya la computadora estaba apagada");
            //     }
    }

}
