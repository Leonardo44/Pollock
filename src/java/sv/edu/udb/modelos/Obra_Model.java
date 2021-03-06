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
import sv.edu.udb.entidades.Comentario;
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
                        _id = "O000" + _c;
                    } else if (_c >= 10 && _c < 100) {
                        _id = "O00" + _c;
                    } else if (_c >= 100 && _c < 1000) {
                        _id = "O0" + _c;
                    } else {
                        _id = "O" + _c;
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
    public static List<Autor> obtenerAutores(){
        List<Autor> _Alist = new ArrayList();
        PreparedStatement consultaSQL = DBConection.getStatement("SELECT * FROM autor");
        try{
            ResultSet data = consultaSQL.executeQuery();
            while(data.next()){
                 Date date = null;
                 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                 try {
                        date = df.parse(data.getString(4));
                    } catch (ParseException ex) {
                        Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
                    }
                _Alist.add(new Autor(data.getString(1), data.getString(2), data.getString(3), date));
                }
            return _Alist;
        }catch(SQLException ex){
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE,null,ex);
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
    
    public static List<Obra> obtenerObras(boolean relaciones){
        List<Obra> _oList = new ArrayList();
        PreparedStatement obtenerLibros = DBConection.getStatement("SELECT * FROM Obra;");
        try {
            try (ResultSet data = obtenerLibros.executeQuery()) {
                if(data != null){
                    while (data.next()) {
                        
                        Obra _o = new Obra(data.getString(1), data.getString(2), data.getString(3), data.getString(4), null);
                        
                        if (relaciones) {
                            PreparedStatement obtenerAutor = DBConection.getStatement("SELECT a.idAutor, a.nombres, a.apellidos, a.fechaNac, a.idPais FROM autor a INNER JOIN obra o ON o.idAutor = a.idAutor WHERE o.idObra = ?;");
                            PreparedStatement obtenerCalificacion = DBConection.getStatement("SELECT calificacion FROM Obra WHERE idObra= ?;");
                            PreparedStatement obtenerComentarios = DBConection.getStatement("SELECT * FROM Comentario WHERE idObra= ?;");

                            obtenerAutor.setString(1, _o.getIdObra());
                            obtenerCalificacion.setString(1, _o.getIdObra());
                            obtenerComentarios.setString(1, _o.getIdObra());

                            ResultSet DataA = obtenerAutor.executeQuery();
                            ResultSet DataC = obtenerCalificacion.executeQuery();
                            ResultSet DataCo = obtenerComentarios.executeQuery();

                            Autor _a = null;
                            float _c = 0;
                            List<Comentario> _co = new ArrayList();

                            Date date = null;
                            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                            if (DataA != null) {
                                while (DataA.next()) {
                                    date = df.parse(DataA.getDate(4).toString());
                                    _a = new Autor(DataA.getString(1), DataA.getString(2), DataA.getString(3), date);
                                }
                            }

                            if (DataC != null) {
                                while (DataC.next()) {
                                    _c += DataC.getFloat(1);
                                }
                            }

                            if (DataCo != null) {
                                while (DataCo.next()) {
                                    date = (DataCo.getDate(3));
                                    _co.add(new Comentario(DataCo.getString(2), date, DataCo.getString(4)));
                                }
                            }

                            _o.setAutor(_a);
                            _o.setCalificacion(_c);
                            _o.setComentarios(_co);
                        }
                        
                        _oList.add(_o);
                    }
                }else{
                    return null;
                }
            } catch (ParseException ex) {
                Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE, null, ex);
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
                    
                    Obra _o = new Obra(
                            dataLibro.getString(1),
                            dataLibro.getString(2),
                            dataLibro.getString(3),
                            dataLibro.getString(4),
                            new Autor(dataLibro.getString(5), false)
                    );
                    
                    if(relaciones){
                        PreparedStatement obtenerAutor = DBConection.getStatement("SELECT a.idAutor, a.nombres, a.apellidos, a.fechaNac, a.idPais FROM autor a INNER JOIN obra o ON o.idAutor = a.idAutor WHERE o.idObra = ?;");
                        PreparedStatement obtenerCalificacion = DBConection.getStatement("SELECT calificacion FROM Obra WHERE idObra= ?;");
                        PreparedStatement obtenerComentarios = DBConection.getStatement("SELECT * FROM Comentario WHERE idObra= ?;");
                        
                        obtenerAutor.setString(1, _o.getIdObra());
                        obtenerCalificacion.setString(1, _o.getIdObra());
                        obtenerComentarios.setString(1, _o.getIdObra());
                        
                        ResultSet DataA = obtenerAutor.executeQuery();
                        ResultSet DataC = obtenerCalificacion.executeQuery();
                        ResultSet DataCo = obtenerComentarios.executeQuery();
                        
                        Autor _a = null;
                        float _c = 0;
                        List<Comentario> _co = new ArrayList();
                        
                        Date date = null;
                        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        
                        if(DataA != null){
                            while (DataA.next()) {
                                date = df.parse(DataA.getDate(4).toString());
                                _a = new Autor(DataA.getString(1), DataA.getString(2), DataA.getString(3), date);
                            }
                        }
                        
                        if(DataC != null){
                            while (DataC.next()) {
                                _c += DataC.getFloat(1);
                            }
                        }

                        if(DataCo != null){
                            while (DataCo.next()) {
                                date = (DataCo.getDate(3));
                                _co.add(new Comentario(DataCo.getString(2), date, DataCo.getString(4)));
                            }
                        }
                        
                        _o.setAutor(_a);
                        _o.setCalificacion(_c);
                        _o.setComentarios(_co);
                    }
                    
                    return _o;
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
    public static List<Obra> BuscarObras(String campo,String busqueda){
        List<Obra> _Olist = new ArrayList();
        List<Autor> _AList = new ArrayList();
        PreparedStatement consultaSQL = DBConection.getStatement("SELECT idObra,nombre,descripcion,imagen,calificacion,idAutor FROM obra WHERE "+ campo +" LIKE '%"+busqueda +"%'");
        try{
            ResultSet data = consultaSQL.executeQuery();
            while(data.next()){
                String idAutor = data.getString("idAutor");
                _AList = obtenerAutores();
                for(Autor _a: _AList){
                    if(_a.getIdAutor().equals(idAutor)){
                        Autor autorObra = new Autor(_a.getIdAutor(),_a.getNombres(),_a.getApellidos());
                        _Olist.add(new Obra(data.getString("idObra"),data.getString("nombre"),data.getString("descripcion"),data.getString("imagen"),autorObra));
                    }
                }
            }
            data.close();
            return _Olist;
        }catch(SQLException ex){
            Logger.getLogger(Obra_Model.class.getName()).log(Level.SEVERE,null, ex);
            return null;
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
                        _oList.add(new Obra(data.getString(1), false));
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
