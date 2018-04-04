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
public class Autor_Model {

    public static List<Autor> obtenerAutores() {
        List<Autor> _aList = new ArrayList();
        try {
            try (ResultSet data = DBConection.getData("SELECT * FROM Autor;")) {
                while (data.next()) {
                    Date date = null;
                    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                    try {
                        date = df.parse(data.getString(4));
                    } catch (ParseException ex) {
                        Logger.getLogger(Autor_Model.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    _aList.add(new Autor(data.getString(1), data.getString(2), data.getString(3), date));
                }
            }
            return _aList;
        } catch (SQLException ex) {
            Logger.getLogger(Autor_Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<Autor> obtenerAutores(String filtros) {
        List<Autor> _aList = new ArrayList();
        try {
            try (ResultSet data = DBConection.getData("SELECT * FROM Autor " + filtros + " ;")) {
                while (data.next()) {
                    Date date = null;
                    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                    try {
                        date = df.parse(data.getString(4));
                    } catch (ParseException ex) {
                        Logger.getLogger(Autor_Model.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    _aList.add(new Autor(data.getString(1), data.getString(2), data.getString(3), date));
                }
            }
            return _aList;
        } catch (SQLException ex) {
            Logger.getLogger(Autor_Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Autor obtenerAutor(String idAutor, boolean relaciones) {
        PreparedStatement obtenerAutor = DBConection.getStatement("SELECT * FROM autor WHERE idAutor = ?;");
        try {
            obtenerAutor.setString(1, idAutor);
            try (ResultSet data = obtenerAutor.executeQuery()) {
                while (data.next()) {
                    Autor _a = new Autor(data.getString(1), data.getString(2), data.getString(3), data.getDate(4));

                    if (relaciones) {
                        PreparedStatement ObtenerAutorObras = DBConection.getStatement("SELECT * FROM Obra WHERE idAutor = ?;");
                        ObtenerAutorObras.setString(1, idAutor);

                        ResultSet DataAO = ObtenerAutorObras.executeQuery();

                        List<Obra> obras = new ArrayList();

                        if (DataAO != null) {
                            while (DataAO.next()) {
                                obras.add(new Obra(DataAO.getString(1), DataAO.getString(2), DataAO.getString(3), DataAO.getString(4), _a));
                            }
                        }

                        _a.setObras(obras);
                    }

                    return _a;
                }
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(Autor_Model.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean insertar(Autor _a) {
        PreparedStatement insertarSQL = DBConection.getStatement("INSERT INTO Autor VALUES(?, ?, ?, ?, ?);");
        try {
            insertarSQL.setString(1, _a.getIdAutor());
            insertarSQL.setString(2, _a.getNombres());
            insertarSQL.setString(3, _a.getApellidos());
            insertarSQL.setDate(4, new java.sql.Date(_a.getFechaNac().getTime()));
            insertarSQL.setString(5, _a.getPais());
            insertarSQL.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Autor_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean modificar(Autor _a) {
        PreparedStatement modificarSQL = DBConection.getStatement("UPDATE Autor SET nombres = ?, apellidos = ?, fechaNac = ?, idPais = ? WHERE idAutor = ?;");
        try {

            modificarSQL.setString(1, _a.getNombres());
            modificarSQL.setString(2, _a.getApellidos());
            modificarSQL.setString(3, _a.getFechaNac().toString());
            modificarSQL.setString(4, _a.getPais());
            modificarSQL.setString(5, _a.getIdAutor());
            modificarSQL.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Autor_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean eliminar(Autor _a) {
        PreparedStatement eliminarSQL = DBConection.getStatement("DELETE FROM Autor WHERE idAutor = ?;");
        try {
            eliminarSQL.setString(1, _a.getIdAutor());
            eliminarSQL.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Autor_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static int obtenerNumAutor() { //Obtiene el numero de usuarios registrados según el tipo
        PreparedStatement query = DBConection.getStatement("SELECT COUNT(*) FROM autor");
        try {
            ResultSet data = query.executeQuery();
            data.next();
            int num = data.getInt(1);
            data.close();
            return num;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_Model.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
