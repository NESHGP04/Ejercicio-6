/*Ejercicio #6 POO``
Marinés García 23391
CLASS Main */

import java.util.*;

public class ElectroTech {

    public static void menu(){
        System.out.println("\n<<<ELECTRO TECH>>>");
        System.out.println("\nMENÚ:");
        System.out.println("\n1.Agregar dispositivo");
        System.out.println("2.Información de dispositivos");
        System.out.println("3.Estado de dispositivos");
        System.out.println("4.Salir");
    }

    public static void main(String[] args) {
        int opc;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        ArrayList<Dispositivos> nuevoDispositivo = new ArrayList<>();
        DispCSV sistema = new DispCSV();

        while(!salir){
            menu();
            System.out.print("\nSeleccione una opción: ");
            opc=sc.nextInt();
            sc.nextLine();

            switch (opc){
                case 1:
                    System.out.println("\n===Agregar dispositivo===");

                    System.out.print("\nIngrese el ID del producto: ");
                    String idSc = sc.nextLine();
                    System.out.print("\nIngrese el tipo del producto: \n1.Teléfono \n2.Computadora \n");
                    int tipoSc = sc.nextInt();
                    sc.nextLine();

                    Dispositivos nuevoDisp = null;
                    if(tipoSc == 1){ //Teléfonos
                        System.out.print("\nIngrese el modelo del producto: ");
                        String modeloSc = sc.nextLine();
                        System.out.print("\nIngrese si el estado del producto: \n1.Encendido \n2.Apagago \n");
                        int estadoSc = sc.nextInt();

                        if(estadoSc == 1){ //Dispositivo encendido
                             nuevoDisp = new Telefono(idSc,1, "Teléfono", modeloSc, " "); //Agrega dispositivo a Array
                        } else if(estadoSc == 2){//Dispositivos apagados
                             nuevoDisp = new Telefono(idSc,0,"Teléfono", modeloSc, " "); //Agrega dispositivo a Array
                        }else{
                            System.out.println("Ingrese un número correcto...");
                        }
                    } else if(tipoSc == 2){ //Computadoras
                            System.out.print("\nIngrese la marca del producto: ");
                            String marcaSc = sc.nextLine();
                            System.out.print("\nIngrese si el estado del producto: \n1.Encendido \n2.Apagago ");
                            int estadoSc = sc.nextInt();

                            if(estadoSc == 1){ //Dispositivo encendido
                                 nuevoDisp = new Computadora(idSc,1, "Teléfono", " ", marcaSc); //Agrega dispositivo a Array
                            } else if(estadoSc == 2){//Dispositivos apagados
                                 nuevoDisp = new Computadora(idSc,0,"Teléfono", " ", marcaSc); //Agrega dispositivo a Array
                            }else{
                            System.out.println("Ingrese un número correcto...");
                            }
                        } else{
                            System.out.println("Ingrese un número correcto...");
                        }

                        if (nuevoDisp != null) {
                            sistema.agregarDispositivo(nuevoDisp);
                            System.out.println("Nuevo producto agregado exitosamente.");
                        }
                    break;

                case 2:
                    System.out.println("\n===Información de dispositivos===");
                    System.out.print("\nIngrese el tipo del dispositivo que dese ver la información: ");
                    String categoria = sc.nextLine();
                    sistema.listarDispositivos(categoria).forEach(dispositivo -> System.out.println(dispositivo.getId())); 
                    break;

                case 3: 
                    System.out.println("\n===Estado de dispositivos===");
                    System.out.print("\nIngrese si el estado del producto: \n1.Encendido \n2.Apagago \n");
                    int estadoSc = sc.nextInt();
                    sc.nextLine();

                    Dispositivos estadoEncontrado = sistema.buscarProductoPorEstado(estadoSc);
                    if(estadoEncontrado != null){
                        System.out.println("Productos: " + estadoEncontrado.toString());    
                    }else{
                            System.out.println("No se encontraron resultados con ese criterio.");
                    }

                    break;   
                case 4:
                    System.out.println("\nHa salido del programa. Gracias por utiizarlo!");
                    salir = true;
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }
        }
        sc.close();
    }
}