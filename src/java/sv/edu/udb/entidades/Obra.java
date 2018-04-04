/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.entidades;

/**
 *
 * @author Frank
 */
public class Obra {
    private String idObra;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Autor autor;

    public String getIdObra() {
        return idObra;
    }

    public void setIdObra(String idObra) {
        this.idObra = idObra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Obra(String idObra, String nombre, String descripcion, String imagen, Autor autor) {
        this.idObra = idObra;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.autor = autor;
    }

    public Obra(String idObra) {
        this.idObra = idObra;
    }
}
