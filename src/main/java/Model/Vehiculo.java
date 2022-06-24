/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author adria
 */
public class Vehiculo {
    
    private boolean disponibilidad;
    private int idItemAlmacen;
    private Modelo modelo;
    private ArrayList<Extra> extras = new ArrayList();
    private Pedido pedido;

    public Vehiculo(boolean disponibilidad, int idItemAlmacen, Modelo modelo) {
        this.disponibilidad = disponibilidad;
        this.idItemAlmacen = idItemAlmacen;
        this.modelo = modelo;
    }

    public void añadirExtras(ArrayList<Extra> extras){
        this.extras = extras;
    }    
    
    public ArrayList<Extra> getExtras(){
        return this.extras;
    }
    
    public Modelo getModelo(){
        return modelo;
    }
    
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public int getIdItemAlmacen() {
        return idItemAlmacen;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    
    
}
