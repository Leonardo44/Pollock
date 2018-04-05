/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.entidades;

import sv.edu.udb.modelos.Obra_Model;

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
    private float calificacion;
    
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
    
    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Obra(String idObra, String nombre, String descripcion, String imagen, Autor autor) {
        this.idObra = idObra;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.autor = autor;
    }
    public Obra(String idObra){
        this.idObra = idObra;
    }
    public Obra(String idObra, boolean relaciones) {
        this.idObra = idObra;
        Obra _o = Obra_Model.obtenerObra(idObra, relaciones);
        if(_o != null){
            this.idObra = _o.idObra;
            this.nombre = _o.nombre;
            this.descripcion = _o.descripcion;
            this.imagen = _o.imagen;
            this.autor = _o.autor;
            this.calificacion = _o.calificacion;
        }else{
            this.idObra = null;
        }
    }
    
    public void cargarDatos(boolean relaciones){
       Obra _o = Obra_Model.obtenerObra(this.idObra, relaciones);
        if(_o != null){
            this.idObra = _o.idObra;
            this.nombre = _o.nombre;
            this.descripcion = _o.descripcion;
            this.imagen = _o.imagen;
            this.autor = _o.autor;
            this.calificacion = _o.calificacion;
        } 
    }
}
