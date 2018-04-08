/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.entidades;

import java.util.Date;

/**
 *
 * @author Frank
 */
public class Comentario {
    private String texto;
    private Date fecha;
    private String idObra;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdObra() {
        return idObra;
    }

    public void setIdObra(String idObra) {
        this.idObra = idObra;
    }

    public Comentario(String texto, Date fecha, String idObra) {
        this.texto = texto;
        this.fecha = fecha;
        this.idObra = idObra;
    }
}
