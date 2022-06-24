/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.ControladorServicio.getClientes;
import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class Cliente {
    
    private String nombre;
    private int telefono;
    private String correo;
    private String dni;
    private String direccion;
    private String contraseña;
    private ArrayList<Pedido> pedidos = new ArrayList();
    
    public Cliente(String nombre, int telefono, String correo, String dni, String direccion, String contraseña) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.dni = dni;
        this.direccion = direccion;
        this.contraseña = contraseña;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    public static String getNombreDeDni(String dni){
        ArrayList<Cliente> clientes = getClientes();
        return clientes.stream().filter(cliente -> cliente.getDni().equalsIgnoreCase(dni))
                .findFirst().map(cliente->cliente.getNombre()).orElse(null);
        
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
}
