package File;

import Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static Model.ControladorServicio.*;

public class CargarDatos {

    public static ArrayList<Cliente> recuperarClientes() throws IOException {
        BufferedReader lector = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            lector = new BufferedReader(new FileReader("Clientes.csv"));
            lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaDividida = linea.split(";");
                Cliente cliente = new Cliente(lineaDividida[0],Integer.parseInt(lineaDividida[1]),lineaDividida[2],lineaDividida[3],lineaDividida[4],lineaDividida[5]);
                cliente.setPedidos(recuperarPedidosDeCliente(lineaDividida[6]));
                clientes.add(cliente);
                linea = lector.readLine();
            }
        } catch (Exception e) {
        } finally {
            if (null != lector) {
                lector.close();
            }
            return clientes;
        }
    }

    private static ArrayList<Pedido> recuperarPedidosDeCliente(String idPedidos) throws IOException {
        ArrayList<Pedido> pedidos = recuperarPedidos();
        String[] idPedidosCliente = idPedidos.substring(1,idPedidos.length()-1).split(",");
        ArrayList<Pedido> pedidosCliente = new ArrayList<Pedido>();
        for(int i=0;i<pedidos.size();i++){
            for(int e=0;i<idPedidosCliente.length;e++){
                if(pedidos.get(i).getIdPedido() == Integer.parseInt(idPedidosCliente[e])){
                    pedidosCliente.add(pedidos.get(i));
                }
                    
            }
        }
        return pedidosCliente;
          
    }
    
    public static ArrayList<Modelo> recuperarModelos() throws IOException {
        BufferedReader lector = null;
        ArrayList<Modelo> modelos = new ArrayList<Modelo>();
        try {

            lector = new BufferedReader(new FileReader("Modelos.csv"));
            lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaDividida = linea.split(";");
                ArrayList<Extra> extrasDisponibles = recuperarExtrasDeObjeto(lineaDividida[7]);
                ArrayList<Vehiculo> vehiculosDisponibles = recuperarVehiculosDisponibles(lineaDividida[1]);
                Modelo modelo = new Modelo(lineaDividida[0], vehiculosDisponibles, Integer.parseInt(lineaDividida[2]),Integer.parseInt(lineaDividida[3]),lineaDividida[4],lineaDividida[5],Integer.parseInt(lineaDividida[6]), extrasDisponibles, lineaDividida[8]);
                anadirComentarios(modelo,lineaDividida[5]);
                modelos.add(modelo);
                linea = lector.readLine();
            }

        } catch (Exception e) {
        } finally {
            if (null != lector) {
                lector.close();
            }
        }
        return modelos;
    }
    
    private static void anadirComentarios(Modelo modelo, String comentarios) {
        if (comentarios.length()>9){
            String[] comentariosLista = comentarios.split("-");
            for (String comentario:comentariosLista) {
                modelo.addComentario(comentario.substring(9), comentario.substring(0,9));
        }
        }
     
    }

    private static ArrayList<Vehiculo> recuperarVehiculosDisponibles(String listaDeInts) {
        ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<Vehiculo>();
        if (listaDeInts.length()>3){
        String[] numeroVehiculo = listaDeInts.substring(1,listaDeInts.length()-1).split(",");
        
        ArrayList<Vehiculo> vehiculos = recuperarVehiculos();
        for(String numero:numeroVehiculo){
            for(Vehiculo vehiculo:vehiculos){
                if(vehiculo.getIdItemAlmacen()==Integer.parseInt(numero.trim()))
                vehiculosDisponibles.add(vehiculo);
            }
            
        }
        return vehiculosDisponibles;
        }
        return vehiculosDisponibles;

    }

    private static ArrayList<Extra> recuperarExtrasDeObjeto(String listaDeExtras) {
        ArrayList<Extra> extrasBuscados = new ArrayList<Extra>();
        if(listaDeExtras.length()>3){
        String[] nombresDeExtras = listaDeExtras.substring(1,listaDeExtras.length()-1).split(",");
        ArrayList<Extra> extras = getExtras();
        ArrayList<Extra> extrasBuscados = new ArrayList<Extra>();
        for (int i=0;i<nombresDeExtras.length;i++){
            String idExtra=nombresDeExtras[i].trim();
            extrasBuscados.add(extras.stream().filter(extra -> extra.getIdExtra() == Integer.parseInt(idExtra)).findFirst().orElse(null));
        }
        return extrasBuscados;            
        }
        return extrasBuscados;   
    }

    public static ArrayList<Pedido> recuperarPedidos() throws IOException {
        BufferedReader lector = null;
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        try {

            lector = new BufferedReader(new FileReader("Pedidos.csv"));
            lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaDividida = linea.split(";");
                Cliente cliente = recuperarClienteDePedido(lineaDividida);
                Vehiculo vehiculo = recuperarVehiculoDePedido(lineaDividida);
                Pedido pedido = new Pedido(cliente,vehiculo);
                pedidos.add(pedido);
                linea = lector.readLine();
            }
            return pedidos;
        } catch (Exception e) {System.out.print(e.toString());
        } finally {
            if (null != lector) {
                lector.close();
            }
            return pedidos;
        }
        
    }


    private static Cliente recuperarClienteDePedido(String[] lineaDividida) {
        ArrayList<Cliente> clientes = getClientes();
       
        return clientes.stream()
                .filter(cliente -> cliente.getDni().equalsIgnoreCase(lineaDividida[0]))     
                .findFirst()
                .get();
    }

    public static ArrayList<Vehiculo> recuperarVehiculos() throws IOException {
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        BufferedReader lector = null;
        try {

            lector = new BufferedReader(new FileReader("Vehiculos.csv"));
            String encabezado = lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaSeparada = linea.split(";");
                Vehiculo vehiculo = new Vehiculo(Boolean.parseBoolean(lineaSeparada[0]),Integer.parseInt(lineaSeparada[1]), recuperarModeloDeVehiculo(lineaSeparada[2]));
                vehiculos.add(vehiculo);
                linea = lector.readLine();
            }
        } catch (Exception e) {
        } finally {
            if (null != lector) {
                lector.close();
            }
            return vehiculos;
        } 
    }

    private static Vehiculo recuperarVehiculoDePedido(String[] lineaDividida) throws IOException {
        ArrayList<Vehiculo> vehiculos = recuperarVehiculos();
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getIdItemAlmacen() == Integer.parseInt(lineaDividida[1]))
                .findFirst()
                .orElse(null);
    }

    private static Modelo recuperarModeloDeVehiculo(String idModelo) {
        ArrayList<Modelo> modelos = getModelos();
        return modelos.stream()
                .filter(modelo -> modelo.getIdModelo()==Integer.parseInt(idModelo))
                .findFirst()
                .orElse(null);
    }

    
    public static ArrayList<Extra>recuperarExtras() throws IOException {
        ArrayList<Extra> extras = new ArrayList<Extra>();
        BufferedReader lector = null;
        try { 

            lector = new BufferedReader(new FileReader("Extras.csv"));
            String encabezado = lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaSeparada = linea.split(";");
                Extra extra = new Extra(lineaSeparada[0],lineaSeparada[1],Integer.parseInt(lineaSeparada[2]),Integer.parseInt(lineaSeparada[3]));
                extras.add(extra);
                linea = lector.readLine();
            }
        } catch (Exception e) {
        } finally {
            if (null != lector) {
                lector.close();
            }
            return extras;
        }
    }





}





