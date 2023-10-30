/*Ejercicio #6 POO``
Marinés García 23391
CLASS */

import java.util.*;
import java.io.*;

public class DispCSV {
    private List<Dispositivos> dispList;

    public DispCSV(){
        dispList = new ArrayList<>();
    }
    
    public void cargarDesdeCSV(String archivoCSV){
        dispList = cargarCSV(archivoCSV);
    }

    private List<Dispositivos> cargarCSV(String archivoCSV){
        List<Dispositivos> dispositivoArray = new ArrayList<>();
        String linea;

        try(BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))){
            reader.readLine(); //Quitamos primera línea para encabezados

            while((linea = reader.readLine()) != null){
                String[] campos = linea.split(",");
                if (campos.length >= 4) {
                    String id = campos[0];
                    int estado = Integer.parseInt(campos[1]);
                    String tipo = campos[2];
                    
                    Dispositivos dispositivo = null;
                    if(tipo.equals("Teléfono")){
                        if(campos.length >= 5){
                            String modelo = campos[3];
                            dispositivo = new Telefono(id, estado, tipo, modelo, " ");
                        } else{
                            dispositivo = new Telefono(id, estado, tipo, " ", " ");
                        }
                        
                    } else if(tipo.equals("Computadora")){
                        if(campos.length >= 6){
                            String marca = campos[4];
                            dispositivo = new Computadora(id, estado, tipo, " ", marca);
                        } else{
                            dispositivo = new Computadora(id,estado, tipo, " ", " ");
                        }
                    } else{
                        System.out.println("Ingre una opción válida");
                    }
                
                if(dispositivo != null){
                        dispositivoArray.add(dispositivo);
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
            
            for(Dispositivos d : dispositivos){ //Escribe los datos de los dispositivos
                writer.print(d.getId() + ",");
                writer.print(d.getModelo()+",");
                writer.println(d.getEstado());

                if(d instanceof Telefono){
                    Telefono tel = (Telefono) d;
                    writer.print(tel.getTipo()+",");
                    writer.print("0");
                } else if(d instanceof Computadora){
                    Computadora compu = (Computadora) d;
                    writer.print("0,");
                    writer.print(compu.getTipo()+",");
                }
                writer.println();
        }
        System.out.println("Productos guardados exitosamente en el archivo CSV.");
        } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error al guardar productos en el archivo CSV.");
        }
    }

    public List<Dispositivos> listarDispositivos(String categoria){
        List<Dispositivos> listaFiltrada = new ArrayList<>();
        for(Dispositivos dispositivo : dispList){
            if(dispositivo.getTipo().equals(categoria)){
                listaFiltrada.add(dispositivo);
            }
        }
        return listaFiltrada;
    }

    public Dispositivos buscarProductoPorEstado(int estado) {
        for (Dispositivos d : dispList) {
            if (d.getEstado() == estado) {
                return d;
            }
        }
        return null; // Devuelve null si no se encuentra el producto
    }
}
