/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.entidades;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Frank
 */
public class Usuario {
    private String idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaNacimiento;
    private String password;
    private boolean estado;
    private boolean sesion;

    public boolean isSesion() {
        return sesion;
    }

    public void setSesion(boolean sesion) {
        this.sesion = sesion;
    }
    private String tipoUsuario;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario(String idUsuario, String nombre, String apellido, String correo, Date fechaNacimiento, String password, boolean estado, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.estado = estado;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String idUsuario, String nombre, String apellido, String correo, Date fechaNacimiento, boolean estado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }
    public Usuario(String correo,String password,boolean sesion){
        this.correo = correo;
        this.password = password;
        this.sesion = sesion;
    }
    public Usuario(String idUsuario, String password) {
        this.idUsuario = idUsuario;
        this.password = password;
    }

    public Usuario(String nombre, String apellido, String correo, Date fechaNacimiento, String password, boolean estado, String tipoUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.estado = estado;
        this.tipoUsuario = tipoUsuario;
    }
    
    public static String crearContransenna(){ //Crea contraseñas aleatorias de 8 caracteres
        Random rnd = new Random();
        String cadena = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVXYZ123456789";
	String contrasenna = "";
        for(int i = 0; i < 8; i++){
            int posicion = rnd.nextInt( cadena.length() );
            contrasenna += cadena.charAt(posicion);
        }
        return contrasenna;
    }
    
    public static String crearNombreUsuario(String tipoUsuario, int numUsuario){
        String nombreUsuario = tipoUsuario;
        if(numUsuario < 10){
            nombreUsuario += "000"+(numUsuario+=1);
        }else if(numUsuario >= 10 && numUsuario < 100){
            nombreUsuario += "00"+(numUsuario+=1);
        }else if(numUsuario >= 100 && numUsuario < 1000){
            nombreUsuario += "0"+(numUsuario+=1);
        }else if(numUsuario >= 1000){
            nombreUsuario += (numUsuario+=1);
        }
        return nombreUsuario;
    }
    
    public static String crearIdUsuario(String nombre, String apellido, int numUsuario){
        String nombreUsuario = String.valueOf(nombre.charAt(0)).toUpperCase() + String.valueOf(apellido.charAt(0)).toUpperCase();
        if(numUsuario < 10){
            nombreUsuario += "000"+(numUsuario+=1);
        }else if(numUsuario >= 10 && numUsuario < 100){
            nombreUsuario += "00"+(numUsuario+=1);
        }else if(numUsuario >= 100 && numUsuario < 1000){
            nombreUsuario += "0"+(numUsuario+=1);
        }else if(numUsuario >= 1000){
            nombreUsuario += (numUsuario+=1);
        }
        return nombreUsuario;
    }
}
