/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        PreparedStatement insertarLibro = DBConection.getStatement("SELECT * FROM Libro;");
        try {
            try (ResultSet data = insertarLibro.executeQuery()) {
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
    
    public static Obra obtenerObra(String id){
        PreparedStatement obtenerLibro = DBConection.getStatement("SELECT * FROM Libro WHERE idLibro = ?;");
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
                    
                    return _l;
                }
            }
            return null;
        } catch (SQLException ex) {    
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static boolean insertar(Obra _o){
        PreparedStatement insertarSQL = DBConection.getStatement("INSERT INTO Obra VALUES(?, ?, ?, ?, ?);");
        try {
            String _id = nuevoId();
            _o.setIdObra(_id);
            insertarSQL.setString(1, _id);
            insertarSQL.setString(2, _o.getNombre());
            insertarSQL.setString(3, _o.getDescripcion());
            insertarSQL.setString(4, _o.getImagen());
            insertarSQL.setString(5, _o.getAutor().getIdAutor());

            insertarSQL.executeUpdate();
            return true;
        } catch (SQLException ex) {    
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean modificar(Obra _o){
        try {
            PreparedStatement modificarSQL = DBConection.getStatement("UPDATE Obra SET nombre = ?, descripcion = ?, imagen = ?, idAutor = ? WHERE idObra = ?;");
            
            modificarSQL.setString(1, _o.getIdObra());
            modificarSQL.setString(2, _o.getNombre());
            modificarSQL.setString(3, _o.getDescripcion());
            modificarSQL.setString(4, _o.getImagen());
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
}
