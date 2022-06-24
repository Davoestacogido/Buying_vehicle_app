package File;

import Model.*;

import java.io.*;
import java.util.ArrayList;

import static Model.ControladorServicio.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargarDatos {

    static ArrayList<Modelo> modelos = new ArrayList<Modelo>();

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
                clientes.add(cliente);
                System.out.println(cliente.getNombre());
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


    
    public static ArrayList<Modelo> recuperarModelos() throws IOException {
        BufferedReader lector = null;


        try {

            lector = new BufferedReader(new FileReader("Modelos.csv"));
            lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaDividida = linea.split(";");
                ArrayList<Extra> extrasDisponibles = recuperarExtrasDeObjeto(lineaDividida[7]);
                System.out.println(lineaDividida[7]);
                Modelo modelo = new Modelo(lineaDividida[0], Integer.parseInt(lineaDividida[2]),Integer.parseInt(lineaDividida[3]),lineaDividida[4],lineaDividida[5],Integer.parseInt(lineaDividida[6]), extrasDisponibles, stringToCombustible(lineaDividida[8]));
                anadirComentarios(modelo,lineaDividida[9]);
                System.out.println(modelo.getIdModelo());
                modelos.add(modelo);
                linea = lector.readLine();
            }
            ArrayList<Vehiculo> todosVehiculos = recuperarVehiculosDeModelo(recuperarVehiculos());
            recuperarPedidos(todosVehiculos);
        } catch (Exception e) {
        } finally {
            if (null != lector) {
                lector.close();
            }
        }
        return modelos;
    }

    public static Modelo.Combustible stringToCombustible(String raw){
        if(raw.equals("diesel"))return Modelo.Combustible.diesel;
        if(raw.equals("gasolina"))return Modelo.Combustible.gasolina;
        if(raw.equals("electrico"))return Modelo.Combustible.electrico;
        else return null;
    }

    private static void anadirComentarios(Modelo modelo, String comentarios) {
        if (comentarios.length()>9){
            String[] comentariosLista = comentarios.split("-");
            for (String comentario:comentariosLista) {
                modelo.addComentario(comentario.substring(9), comentario.substring(0,9));
        }
        }
     
    }

    private static ArrayList<Vehiculo> recuperarVehiculosDeModelo(ArrayList<Vehiculo> vehiculos) {
        ArrayList<Vehiculo> todosVehiculos = new ArrayList<Vehiculo>();
        for(Vehiculo vehiculo: vehiculos){
            for(Modelo modelo: modelos){
                if(vehiculo.getModelo().getIdModelo()==modelo.getIdModelo()){
                    todosVehiculos.add(vehiculo);
                    modelo.addVehiculo(vehiculo);
                }
            }
        }
        return todosVehiculos;

    }


    private static ArrayList<Extra> recuperarExtrasDeObjeto(String listaDeExtras) {
        ArrayList<Extra> extrasBuscados = new ArrayList<Extra>();
        if(listaDeExtras.length()>3){
            try {
                String[] nombresDeExtras = listaDeExtras.substring(1,listaDeExtras.length()-1).split(",");
                ArrayList<Extra> extras = recuperarExtras();
                for (int i=0;i<nombresDeExtras.length;i++){
                    String idExtra=nombresDeExtras[i].trim();
                    extrasBuscados.add(extras.stream().filter(extra -> extra.getIdExtra() == Integer.parseInt(idExtra)).findFirst().orElse(null));
                }            
                return extrasBuscados;
            } catch (IOException ex) {
                Logger.getLogger(CargarDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return extrasBuscados;   
    }

    public static void recuperarPedidos(ArrayList<Vehiculo> vehiculos) throws IOException {
        BufferedReader lector = null;
        try {
            lector = new BufferedReader(new FileReader("Pedidos.csv"));
            lector.readLine();
            String linea = lector.readLine();
            while (null != linea) {
                String[] lineaDividida = linea.split(";");
                Cliente cliente = recuperarClienteDePedido(lineaDividida);
                Vehiculo vehiculo = recuperarVehiculoDePedido(lineaDividida, vehiculos);
                Pedido pedido = new Pedido(cliente,vehiculo,stringToEstado(lineaDividida[4]));
                pedido.setFechaEntrega(lineaDividida[5]);
                añadirPedido(cliente, vehiculo, pedido);
                linea = lector.readLine();
            }
        } catch (Exception e) {System.out.print(e.toString());
        } finally {
            if (null != lector) {
                lector.close();
            }
        }
        
    }

    private static void añadirPedido(Cliente cliente, Vehiculo vehiculo, Pedido pedido) {
        cliente.addPedido(pedido);
        vehiculo.setPedido(pedido);
    }

    public static Pedido.Estado stringToEstado(String raw){
        if(raw.equals("enCamino"))return Pedido.Estado.enCamino;
        if(raw.equals("entregado"))return Pedido.Estado.entregado;
        else return null;
    }

    private static Cliente recuperarClienteDePedido(String[] lineaDividida) {
        ArrayList<Cliente> clientes = getClientes();
       
        return clientes.stream()
                .filter(cliente -> cliente.getDni().equalsIgnoreCase(lineaDividida[1]))
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
                Vehiculo vehiculo = new Vehiculo(Boolean.parseBoolean(lineaSeparada[0]),Integer.parseInt(lineaSeparada[1]), recuperarModeloDeVehiculo(lineaSeparada[4]));

                if (lineaSeparada[2].length()>3){
                    vehiculo.añadirExtras(recuperarExtrasDeObjeto(lineaSeparada[2]));
                }

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

    private static Vehiculo recuperarVehiculoDePedido(String[] lineaDividida,ArrayList<Vehiculo> vehiculos) throws IOException {
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getIdItemAlmacen() == Integer.parseInt(lineaDividida[2]))
                .findFirst()
                .orElse(null);
    }

    private static Modelo recuperarModeloDeVehiculo(String idModelo) {

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











