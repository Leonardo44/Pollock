/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.servlets;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sv.edu.udb.entidades.Comentario;
import sv.edu.udb.modelos.Comentario_Model;

/**
 *
 * @author Frank
 */
@WebServlet(name = "ComentarServler", urlPatterns = {"/comentar"})
public class ComentarServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json; charset=UTF-8");

        String[] filtros = {
            "puta", "mierdero", "cerotada", "pendejo", "pendeja", "pendejada", "pene", "vagina", "culo", "estúpido",
            "mierda", "culote", "estúpida", "estupido", "estupida", "0te", "pne", "qlo", "chocho", "toto", "chichotas", "chiches",
            "cerote", "pedorro", "pedo", "coger", "cogido", "malcogido", "malcogida",
            "hijo de puta", "vergon", "vergón", "verga", "ponronga", "pichurra", "vulva", "cuquita", "mrd",
            "maldito", "qca", "qquita", "qkita", "qka", "tetonas", "tetotas", "tetitas", "ttas", "tetas", "te lleno de leche",
            "maldita",
            "hija de puta"
        };
        
        String filtroStr = "(?i)(";
        
        for(String _s : filtros){
            filtroStr += _s + "|";
        }
        filtroStr = filtroStr.substring(0, filtroStr.length() - 1);
        filtroStr += ")";

        Gson gson = new Gson();
        
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (IOException e) {
            Logger.getLogger(RateServlet.class.getName()).log(Level.SEVERE, null, e);
            try (PrintWriter out = response.getWriter()) {
                out.print(gson.toJson(false));
            }
        }
        
        Comentario _c = gson.fromJson(jb.toString(), Comentario.class);
        
        _c.setTexto(_c.getTexto().replaceAll(filtroStr, "***"));
        
        try (PrintWriter out = response.getWriter()) {
            out.print(gson.toJson(Comentario_Model.insertarComentario(_c) ? _c : false));
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
