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
public class Modelo {
    
    private String nombre;
    private ArrayList<Vehiculo> vehiculos = new ArrayList();
    private int idModelo;
    private ArrayList<Extra> extras = new ArrayList();
    private int precioBase;
    private ArrayList<Comentario> comentarios = new ArrayList();
    private String marca;
    private int nPuertas;
    private String motor;
    private Combustible combustible;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNPuertas() {
        return nPuertas;
    }

    public void setNPuertas(int nPuertas) {
        this.nPuertas = nPuertas;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }
    
    public enum Combustible{
        diesel,gasolina,electrico
    }

    public Modelo(String nombre, int idModelo, int precioBase, String marca, String motor,int nPuertas, ArrayList<Extra> extrasDisponibles,Combustible combustible) {
        
        this.nombre = nombre;
        this.idModelo = idModelo;
        this.extras = extrasDisponibles;
        this.precioBase = precioBase;
        this.marca = marca;
        this.nPuertas = nPuertas;
        this.motor = motor;
        this.combustible = combustible;
    }
    
 
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public int getIdModelo() {
        return idModelo;
    }


    public ArrayList<Extra> getExtras() {
        return extras;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public Vehiculo isAnyCars(){
        for(int i = 0; i < getVehiculos().size(); i++){
            if(getVehiculos().get(i).isDisponibilidad() == true){
                return getVehiculos().get(i);
            }
        }
        return null;
    }

    public void addComentario(String texto, String autorDni){
        Comentario comentario = new Comentario(texto, autorDni);
        comentarios.add(comentario);
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
    
}
