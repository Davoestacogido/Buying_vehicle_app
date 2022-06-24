/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author adria
 */
public class Comentario {
    
    private String comentario;
    private String autorDni;

    public Comentario(String comentario, String autorDni) {
        this.comentario = comentario;
        this.autorDni = autorDni;
    }

    public String getComentario() {
        return comentario;
    }

    public String getAutorDni() {
        return autorDni;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return comentario + " ;"+Cliente.getNombreDeDni(autorDni);
    }
    
    
}
