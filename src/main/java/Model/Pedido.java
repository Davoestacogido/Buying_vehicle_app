/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
/**
 *
 * @author adria
 */
public class Pedido {
    
    private String fechaEntrega;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int precio;
    private Estado estado;
    int idPedido;

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

   

    public enum Estado {
        enCamino, entregado
    }


    public Pedido(Cliente cliente, Vehiculo vehiculo, Estado estado) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        calcularPrecio();
        vehiculo.setDisponibilidad(false);
        this.fechaEntrega = LocalDate.now().plusDays(7).toString(); 
        this.idPedido = vehiculo.getIdItemAlmacen();
        this.estado = estado;
    }

    public void calcularPrecio(){
        int index = 0;
        int precioAñadido = 0;
        try{
            while(true){
                precioAñadido += this.vehiculo.getExtras().get(index).getPrecioAñadido();
                index++;
            }
        }catch(Exception e){
        this.precio = vehiculo.getModelo().getPrecioBase()+ precioAñadido;
        }
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }


    public int getPrecio() {
        return precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String extras = "";
        for(int i = 0; i < vehiculo.getExtras().size(); i++) extras += vehiculo.getExtras().get(i).getNombre() + " ";
        return"Fecha Entrega = " + fechaEntrega + " modelo = " + vehiculo.getModelo().getNombre() + " extras Seleccionados = " + 
        extras  + " precio = " + precio +" euros" + " estado= " + estado.toString();
    }
    
    public Estado stringToEnum(String raw){
        if(raw.equals("enCamino"))return Estado.enCamino;
        if(raw.equals("entregado"))return Estado.entregado;
        else return null;
    }
    
}
