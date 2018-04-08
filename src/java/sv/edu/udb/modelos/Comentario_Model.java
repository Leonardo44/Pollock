/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.modelos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.connection.DBConection;
import sv.edu.udb.entidades.Comentario;

/**
 *
 * @author Frank
 */
public class Comentario_Model {
    
    public static boolean insertarComentario(Comentario _c){
        try{
            PreparedStatement registrarComentario = DBConection.getStatement("INSERT INTO Comentario(texto, idObra) VALUES (?, ?)");

            registrarComentario.setString(1, _c.getTexto());
            registrarComentario.setString(2, _c.getIdObra());
            registrarComentario.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Comentario_Model.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
