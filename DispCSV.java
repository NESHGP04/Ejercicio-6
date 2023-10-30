/*Ejercicio #6 POO``
Marinés García 23391
CLASS */

import java.util.*;
import java.io.*;

public class DispCSV {
    private List<Dispositivos> dispList;

    public DispCSV(){ //Clase para el arraylist de dispositivos
        dispList = new ArrayList<>();
    }
    
    public void cargarDesdeCSV(String archivoCSV){ //Carga arraylist desde CSV
        dispList = cargarCSV(archivoCSV);
    }

    private List<Dispositivos> cargarCSV(String archivoCSV){ //Crea archivo CSV con la posición de cada campo
        List<Dispositivos> dispositivoArray = new ArrayList<>();
        String linea;

        try(BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))){
            reader.readLine(); //Quitamos primera línea para encabezados

            while((linea = reader.readLine()) != null){
                String[] campos = linea.split(","); //Matriz con valores separados por comas
                if (campos.length >= 4) {
                    String id = campos[0];
                    int estado = Integer.parseInt(campos[1]);
                    String tipo = campos[2];
                    
                    Dispositivos dispositivo = null;
                    if(tipo.equals("Teléfono")){ //Si es un Teléfono, se agregará al array con tipo Telefono
                        if(campos.length >= 5){
                            String modelo = campos[3];
                            dispositivo = new Telefono(id, estado, tipo, modelo, " ");
                        } else{
                            dispositivo = new Telefono(id, estado, tipo, " ", " "); //Agrega espacio en blanco si no es teléfono
                        }
                        
                    } else if(tipo.equals("Computadora")){ //Si es una Computadora, se agregará al array con tipo Computadora
                        if(campos.length >= 6){
                            String marca = campos[4];
                            dispositivo = new Computadora(id, estado, tipo, " ", marca);
                        } else{
                            dispositivo = new Computadora(id,estado, tipo, " ", " "); //Agrega espacio en blanco si no es computadora
                        }
                    } else{
                        System.out.println("Ingre una opción válida");
                    }
                
                if(dispositivo != null){
                        dispositivoArray.add(dispositivo); //Si el array no está vacio, se agregan los inputs al CSV
                    }
            }
        }
        System.out.println("Productos cargados exutosamente!");
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Error al cargar el producto...");
        }
        return dispositivoArray;

    }

    public void agregarDispositivo(Dispositivos dispositivo){
        dispList.add(dispositivo);
        guardarCSV("Dispositivos.csv", dispList); //Guarda los cambios en el csv
    }

    //Guarda info en CSV
    private void guardarCSV(String archivoCSV, List<Dispositivos> dispositivos){
        try(PrintWriter writer = new PrintWriter(new FileWriter(archivoCSV))){
            writer.println("ID,Estado,Tipo,Modelo,Marca,"); //Escribe encabezados en CSV
            
            for(Dispositivos d : dispositivos){ //Escribe los datos de TODOS los dispositivos
                writer.print(d.getId()+",");
                writer.println(d.getEstado()+",");

                if(d instanceof Telefono){ //Escribe datos solo si es Teléfono
                    Telefono tel = (Telefono) d;
                    writer.print(tel.getTipo()+",");
                    writer.print(tel.getModelo()+ "");
                    writer.print(" "); //Espacio en blanco para 'marca'
                } else if(d instanceof Computadora){//Escribe datos solo si es Computadora
                    Computadora compu = (Computadora) d;
                    writer.print(compu.getTipo()+",");
                    writer.print(","); //Espacio en blanco para 'modelo'
                    writer.print(compu.getMarca()+"");
                }
                writer.println();
        }
        System.out.println("Productos guardados exitosamente en el archivo CSV.");
        } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error al guardar productos en el archivo CSV.");
        }
    }

    //Clase para hacer lista de dispositivos de una categoría específica
    public List<Dispositivos> listarDispositivos(String categoria){
        List<Dispositivos> listaFiltrada = new ArrayList<>();
        for(Dispositivos dispositivo : dispList){ //Busca en array
            if(dispositivo.getTipo().equals(categoria)){
                listaFiltrada.add(dispositivo); //Filtra listado
            }
        }
        return listaFiltrada; //Muestra listado
    }

    //Busca productos con un estado específico
    public Dispositivos buscarProductoPorEstado(int estado) {
        for (Dispositivos d : dispList) { //Busca en array
            if (d.getEstado() == estado) {
                return d; //Devuelve los dispositivos con ese estado
            }
        }
        return null; // Devuelve null si no se encuentra el producto
    }
}