/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import static File.CargarDatos.*;
import file.GuardarDatos;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class ControladorServicio {
   private static ArrayList<Cliente> clientes = new ArrayList();
   private static ArrayList<Modelo> modelos = new ArrayList();
   private static String clienteActualDni;

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static ArrayList<Modelo> getModelos() {
        return modelos;
    }

    
    public static void setClientes(ArrayList<Cliente> clientes) {
        ControladorServicio.clientes = clientes;
    }

    public static void setModelos(ArrayList<Modelo> modelos) {
        ControladorServicio.modelos = modelos;
    }


    public static Cliente getClienteActual() {
        Cliente clienteAct = null;
        for(Cliente cliente : getClientes()){
            if(cliente.getDni().equals(clienteActualDni))
                clienteAct = cliente;
        }
        return clienteAct;
    }

    public static void setClienteActual(String Dni) {
        ControladorServicio.clienteActualDni = Dni;
    }
    
    public void cargarDatos() throws IOException {
        clientes= recuperarClientes();
        System.out.print(String.valueOf(clientes.size()) + "\n");
        modelos=recuperarModelos();
        System.out.print(String.valueOf(modelos.size()) + "\n");
        
    }
   
    public static void guardarDatos() throws IOException{
        GuardarDatos guardarDatos = new GuardarDatos();
        guardarDatos.guardarClientes(getClientes());
        guardarDatos.guardarModelos(getModelos()); 
    }
    
    public static Cliente crearCliente(String nombre, int telefono, String correo, String dni, String direccion, String contraseña){
       Cliente cliente = new Cliente(nombre,telefono,correo,dni,direccion,contraseña);
       clientes.add(cliente);
       System.out.print(cliente);
       return cliente;
   }
   
   public static Pedido crearNuevoPedido(Cliente cliente,Modelo modelo,ArrayList<Extra> extras,Pedido.Estado estado){
       Vehiculo vehiculo = modelo.isAnyCars();
       if(vehiculo.equals(null))return null;
       vehiculo.añadirExtras(extras);
       Pedido pedido = new Pedido(cliente,vehiculo,estado);
       getClienteActual().addPedido(pedido);
       vehiculo.setPedido(pedido);
       return pedido;
   }
   
   public static Modelo crearModelo(String nombre, int idModelo, int precioBase, String Marca, String Motor,int nPuertas, ArrayList<Extra> extrasDisponibles,Modelo.Combustible combustible){
       Modelo modelo = new Modelo(nombre, idModelo, precioBase,Marca,Motor,nPuertas,extrasDisponibles,combustible);
       getModelos().add(modelo);
       return modelo;
   }
    
   public static Vehiculo crearVehiculo(boolean disponibilidad, int idItemAlmacen, Modelo modelo){
       Vehiculo vehiculo = new Vehiculo(disponibilidad,idItemAlmacen,modelo);
       modelo.getVehiculos().add(vehiculo);
       return vehiculo;
   }
   
   public static Cliente eliminarCliente(String DNI){
       int i = 0;
       for(Cliente cliente : clientes){
            if(cliente.getDni().equals(DNI)){
                clientes.remove(i);
                return cliente;
            }
            i++;
        }
       return null;
   }
   
   public static Pedido eliminarPedido(String dni,int id){
       int i = 0;
       for(Cliente cliente : clientes){
            if(cliente.getDni().equals(dni)){
                for(Pedido pedido : cliente.getPedidos()){
                    if(pedido.getIdPedido() == id ){
                        cliente.getPedidos().remove(i);
                        return pedido;
                    }
                    i++; 
                }
            }
        }
       return null;
   }
   
   public static Modelo eliminarModelo(int idModelo){
       int i=0;
       for(Modelo modelo : modelos){
           if(modelo.getIdModelo() == idModelo){
               modelos.remove(i);
               return modelo;
           }
           i++;
       }
       return null;
   }
   
   public static Vehiculo eliminarVehiculo(int idModelo,int idItemAlmacen){
       int i=0;
       for(Modelo modelo : modelos){
           if(modelo.getIdModelo() == idModelo){
               for(Vehiculo vehiculo : modelo.getVehiculos()){
                   if(vehiculo.getIdItemAlmacen() == idItemAlmacen){
                       modelo.getVehiculos().remove(i);
                       return vehiculo;
                    }
                   i++;
               }
           }
       }
       return null;
   }
}
