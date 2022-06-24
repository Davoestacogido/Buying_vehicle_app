/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
/**
 *
 * @author adria
 */

import Model.ControladorServicio;
import Model.Modelo;

import Gui.AppConcesionarioUI;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppConcesionario {
    private static ControladorServicio concesionario;
    public static void main(String[] args) throws IOException{
        ControladorServicio concesionario = new ControladorServicio();
        AppConcesionario.concesionario = concesionario;
        concesionario.cargarDatos();
        AppConcesionarioUI interfaz = new AppConcesionarioUI();
        interfaz.notLoggedIn();
        interfaz.setVisible(true);
        
    }
    
    public void guardarDatos(){
        try {
            concesionario.guardarDatos();
        } catch (IOException ex) {
            Logger.getLogger(AppConcesionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
