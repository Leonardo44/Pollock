/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.connection.DBConection;
import sv.edu.udb.entidades.Autor;
import sv.edu.udb.entidades.Obra;

/**
 *
 * @author Frank
 */
public class Obra_Model {
    public static String nuevoId(){
        String _id;
        int _c;
        try {
            try (ResultSet _r = DBConection.getData("SELECT MAX(CAST(SUBSTRING(idObra, 3, 5) AS UNSIGNED)) AS newId FROM Obra;")) {
                _r.next();
                if(_r.getString("newId") != null){
                    _c = Integer.parseInt(_r.getString("newId")) + 1;
                    
                    if (_c < 10) {
                        _id = "L000" + _c;
                    } else if (_c >= 10 && _c < 100) {
                        _id = "L00" + _c;
                    } else if (_c >= 100 && _c < 1000) {
                        _id = "L0" + _c;
                    } else {
                        _id = "L" + _c;
                    }
                }else{
                    _id = "O0001";
                }
            }
            return _id;
        } catch (SQLException ex) {
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<Obra> obtenerObras(){
        List<Obra> _oList = new ArrayList();
        PreparedStatement obtenerLibros = DBConection.getStatement("SELECT * FROM Obra;");
        try {
            try (ResultSet data = obtenerLibros.executeQuery()) {
                if(data != null){
                    while (data.next()) {
                        _oList.add(new Obra(data.getString(1), data.getString(2), data.getString(3), data.getString(4), new Autor(data.getString(5), false)));
                    }
                }else{
                    return null;
                }
            }
            return _oList;
        } catch (SQLException ex) {    
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static Obra obtenerObra(String id, boolean relaciones){
        PreparedStatement obtenerLibro = DBConection.getStatement("SELECT * FROM Obra WHERE idObra = ?;");
        try {
            obtenerLibro.setString(1, id);
            try (ResultSet dataLibro = obtenerLibro.executeQuery()) {
                while(dataLibro.next()){
                    
                    Obra _l = new Obra(
                            dataLibro.getString(1),
                            dataLibro.getString(2),
                            dataLibro.getString(3),
                            dataLibro.getString(4),
                            new Autor(dataLibro.getString(5), false)
                    );
                    
                    if(relaciones){
                        PreparedStatement obtenerAutor = DBConection.getStatement("SELECT a.idAutor, a.nombres, a.apellidos, a.fechaNac, a.idPais FROM autor a INNER JOIN obra o ON o.idAutor = a.idAutor WHERE o.idObra = ?;");
                        PreparedStatement obtenerCalificacion = DBConection.getStatement("SELECT calificacion FROM Obra WHERE idObra= ?;");
                        
                        obtenerAutor.setString(1, _l.getIdObra());
                        obtenerCalificacion.setString(1, _l.getIdObra());
                        
                        ResultSet DataA = obtenerAutor.executeQuery();
                        ResultSet DataC = obtenerCalificacion.executeQuery();
                        
                        Autor _a = null;
                        float _c = 0;
                        
                        Date date;
                        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        
                        if(DataA != null){
                            while (DataA.next()) {
                                date = df.parse(DataA.getString(4));
                                _a = new Autor(DataA.getString(1), DataA.getString(2), DataA.getString(3), date);
                            }
                        }
                        
                        if(DataC != null){
                            while (DataC.next()) {
                                _c += DataC.getFloat(1);
                            }
                        }
                        
                        _l.setAutor(_a);
                        _l.setCalificacion(_c);
                    }
                    
                    return _l;
                }
            } catch (ParseException ex) {
                Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            return null;
        } catch (SQLException ex) {    
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static boolean insertar(Obra _o){
        PreparedStatement insertarSQL = DBConection.getStatement("INSERT INTO Obra(idObra, nombre, descripcion, imagen, idAutor) VALUES(?, ?, ?, ?, ?);");
        try {
            String _id = nuevoId();
            _o.setIdObra(_id);
            insertarSQL.setString(1, _id);
            insertarSQL.setString(2, _o.getNombre());
            insertarSQL.setString(3, _o.getDescripcion());
            insertarSQL.setString(4, _o.getImagen());
            insertarSQL.setString(4, _o.getAutor().getIdAutor());

            insertarSQL.executeUpdate();
            return true;
        } catch (SQLException ex) {    
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean modificar(Obra _o){
        try {
            PreparedStatement modificarSQL = DBConection.getStatement("UPDATE Obra SET nombre = ?, descripcion = ?, imagen = ?, calificacion = ?, idAutor = ? WHERE idObra = ?;");
            
            modificarSQL.setString(6, _o.getIdObra());
            modificarSQL.setString(1, _o.getNombre());
            modificarSQL.setString(2, _o.getDescripcion());
            modificarSQL.setString(3, _o.getImagen());
            modificarSQL.setFloat(4, _o.getCalificacion());
            modificarSQL.setString(5, _o.getAutor().getIdAutor());
            modificarSQL.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean eliminar(Obra _o){
        try {
            PreparedStatement eliminarSQL = DBConection.getStatement("DELETE FROM Obra WHERE idObra = ?;");
            eliminarSQL.setString(1, _o.getIdObra());

            eliminarSQL.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static List<Obra> obtenerObrasAutor(String id){ //Obtiene las obras de un autor
        List<Obra> _oList = new ArrayList();
        PreparedStatement obtenerLibro = DBConection.getStatement("SELECT idObra FROM Obra WHERE idAutor = ?;");
        try {
            obtenerLibro.setString(1, id);
            try (ResultSet data = obtenerLibro.executeQuery()) {
                if(data != null){
                    while (data.next()) {
                        _oList.add(new Obra(data.getString(1)));
                    }
                }else{
                    return null;
                }
            }
            return _oList;
        } catch (SQLException ex) {    
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
