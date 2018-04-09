/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.entidades;

import java.util.Date;
import java.util.List;
import sv.edu.udb.modelos.Autor_Model;

/**
 *
 * @author Frank
 */
public class Autor {

    private String idAutor;
    private String nombres;
    private String apellidos;
    private Date fechaNac;
    private String pais;
    private List<Obra> obras;

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Obra> getObras() {
        return obras;
    }

    public void setObras(List<Obra> obras) {
        this.obras = obras;
    }

    public Autor(String idAutor, String nombres, String apellidos, Date fechaNac, String pais, List<Obra> obras) {
        this.idAutor = idAutor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.pais = pais;
        this.obras = obras;
    }

    public Autor(String idAutor, String nombres, String apellidos, Date fechaNac, String pais) {
        this.idAutor = idAutor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.pais = pais;
    }

    public Autor(String idAutor, String nombres, String apellidos, Date fechaNac) {
        this.idAutor = idAutor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
    }

    public Autor(String idAutor, String nombres, String apellidos) {
        this.idAutor = idAutor;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Autor(String nombres, String apellidos, List<Obra> obras) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.obras = obras;
    }

    public Autor(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Autor(String idAutor, boolean relaciones) {
        Autor _a = Autor_Model.obtenerAutor(idAutor, relaciones);
        if (_a != null) {
            this.idAutor = _a.getIdAutor();
            this.nombres = _a.getNombres();
            this.apellidos = _a.getApellidos();
            this.fechaNac = _a.getFechaNac();
            this.pais = _a.getPais();
            this.obras = _a.getObras();
        }
    }
    public static String crearNombreAutor(int numAutor) {
        String nombreAutor = "A";
        if (numAutor < 10) {
            nombreAutor += "000" + (numAutor += 1);
        } else if (numAutor >= 10 && numAutor < 100) {
            nombreAutor += "00" + (numAutor += 1);
        } else if (numAutor >= 100 && numAutor < 1000) {
            nombreAutor += "0" + (numAutor += 1);
        } else if (numAutor >= 1000) {
            nombreAutor += (numAutor += 1);
        }
        return nombreAutor;
    }
}
