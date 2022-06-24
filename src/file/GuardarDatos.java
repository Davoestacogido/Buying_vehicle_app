package File;

import Model.Cliente;
import Model.Modelo;
import Model.Pedido;
import Model.Vehiculo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GuardarDatos {

    public void guardarClientes(ArrayList<Cliente> filas) throws IOException {
        FileWriter archivo = crearAbrirArchivo("Clientes");
        ArrayList<Integer> idsPedidos = new ArrayList<Integer>();
        try {
            
            PrintWriter escritor= new PrintWriter(archivo,false);
            for (int i = 0; i < filas.size(); i++) {
                  
                for (int e = 0; e < filas.get(i).getPedidos().size(); e++){
                    idsPedidos.add(filas.get(i).getPedidos().get(e).getidPedido());
                }
                
                escritor.append(filas.get(i).getNombre() + ";" + filas.get(i).getTelefono() + ";" +
                        filas.get(i).getCorreo() + ";" + filas.get(i).getDni() + ";" +
                        filas.get(i).getDireccion() + ";" + filas.get(i).getContraseña() + ";" +
                        idsPedidos.toString() + "\n");
                idsPedidos.clear();
            }
            cerrarArchivo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarModelos(ArrayList<Modelo> filas) throws IOException {
        FileWriter archivo = crearAbrirArchivo("Modelos");
        ArrayList<String> extras = new ArrayList<String>();
        ArrayList<String> listaComentarios = new ArrayList<String>();
        ArrayList<Integer> listaVehiculos = new ArrayList<Integer>();
        try {
            PrintWriter escritor= new PrintWriter(archivo, false);
            for (int i = 0; i < filas.size(); i++) {
                for (int e = 0; e<filas.get(i).getExtras().size();e++){
                    extras.add(filas.get(i).getExtras().get(e).getNombre());
                }
                for (int j = 0; j <filas.get(i).getComentarios().size() ; j++) {
                    listaComentarios.add(filas.get(i).getComentarios().get(j).getAutorDni()+filas.get(i).getComentarios().get(j).getComentario());
                }
  
                 for (int k = 0; k <filas.get(i).getVehiculos().size() ; k++) {
                    listaVehiculos.add(filas.get(i).getVehiculos().get(k).getIdItemAlmacen());
                }
                 
                    escritor.append(filas.get(i).getNombre()  + ";" +
                    listaVehiculos.toString() + ";" +
                    filas.get(i).getIdModelo() + ";" +
                    filas.get(i).getPrecioBase() + ";" +
                    filas.get(i).getMarca() + ";" +
                    filas.get(i).getMotor() + ";" +
                    filas.get(i).getnPuertas() + ";" +
                    extras.toString() + ";" +
                    listaComentarios.stream().collect(Collectors.joining("-")).toString() + ";" + 
                    filas.get(i).getCombustible() + "\n");
                    extras.clear();
                    listaComentarios.clear();    
                    listaVehiculos.clear();
                    
            }

            cerrarArchivo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarPedidos(ArrayList<Pedido> filas) throws IOException {
        
        FileWriter archivo = crearAbrirArchivo("Pedidos");
        
        try {
            PrintWriter escritor= new PrintWriter(archivo, false);
            for (int i = 0; i < filas.size(); i++) {
                
                
                escritor.append( 
                        filas.get(i).getidPedido() + ";" +
                        filas.get(i).getCliente().getDni()+ ";" +
                        String.valueOf(filas.get(i).getVehiculo().getIdItemAlmacen())  + ";" +
                        filas.get(i).getPrecio() + ";" +
                        filas.get(i).getEstado() + ";" +
                        filas.get(i).getFechaEntrega() +"\n");
                
                
               
            }

            cerrarArchivo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarVehiculos(ArrayList<Vehiculo> filas) throws IOException {
        FileWriter archivo = crearAbrirArchivo("Vehiculos");
        ArrayList<String> extras = new ArrayList<String>();
        try {
            PrintWriter escritor= new PrintWriter(archivo, false);
            for (int i = 0; i < filas.size(); i++) {
                 
                for (int e = 0; e<filas.get(i).getExtras().size();e++){
                    extras.add(filas.get(i).getExtras().get(e).getNombre());
                }
                
                
                escritor.append(filas.get(i).isDisponibilidad() + ";" +
                        filas.get(i).getIdItemAlmacen() + ":" + 
                        filas.get(i).getExtras().toString() + ";" + 
                        String.valueOf(filas.get(i).getPedido.getIdPedido()) + ";" +
                        String.valueOf(filas.get(i).getModelo().getIdModelo())
                                + "\n");
            }
            cerrarArchivo(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FileWriter crearAbrirArchivo(String nombreArchivo) throws IOException {


        FileWriter escritorDeArchivo = new FileWriter(System.getProperty("user.dir") + "\\" + nombreArchivo + ".csv");

        PrintWriter escritor = new PrintWriter(escritorDeArchivo, false);
            escribirEncabezado(nombreArchivo, escritor);
            return escritorDeArchivo;
        
    }

    private void escribirEncabezado(String nombreArchivo, PrintWriter escritor) {
        if ("Clientes".equals(nombreArchivo)){
            escritor.append("Nombre" + ";" + "Telefono" + ";" +
                    "Correo" + ";" + "Dni" + ";" +
                    "Direccion" + ";" + "Contraseña" + ";" + "Ids de pedidos" +"\n");
        }
        
        else if ("Modelos".equals(nombreArchivo)){
            escritor.append("Nombre" + ";" + "Id de Vehiculos" + ";" + "Id del Modelo" + ";" + "Precio Base" + ";" +
                    ";" + "Marca" + ";" + "Motor" + ";" + "nPuertas" + ";" + "Extras disponibles" + ";" + "Combustible" +";" + "Comentarios (dni+comentario)" + "\n");
        }
        
        else if ("Vehiculos".equals(nombreArchivo)){
            escritor.append("Disponibilidad" + ";" + "Id del almacen" + ";" + "Extras" + ";" + "Id de pedido"  + ";" + "Id de Modelo" + "\n");
        }

        else if ("Pedidos".equals(nombreArchivo)){
            escritor.append("Id pedido" + ";" + "Dni del cliente" + ";" + "Id del vehiculo" + ";" + "Precio" + ";" + "Estado del pedido" + ";" +
                    "Fecha de la entrega" +"\n");

        }
    }

    public void cerrarArchivo(FileWriter file) {
        try {
            if (null != file)
                file.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }


}
        


