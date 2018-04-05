/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.entidades.Obra;
import sv.edu.udb.modelos.Obra_Model;

/**
 *
 * @author Frank
 */
@WebServlet(name = "RateServlet", urlPatterns = {"/Rate"})
public class RateServlet extends HttpServlet {

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
        
        Obra _o = gson.fromJson(jb.toString(), Obra.class);
        Obra _nO = new Obra(_o.getIdObra(), true);
        
        if(_nO.getIdObra() != null){
            _nO.setCalificacion((_nO.getCalificacion() + _o.getCalificacion()) / (_nO.getCalificacion() == 0 ? 1 : 2));
            
            try (PrintWriter out = response.getWriter()) {
                out.print(gson.toJson(Obra_Model.modificar(_nO) ? _nO : false));
            }
        }else{
            try (PrintWriter out = response.getWriter()) {
                out.print(gson.toJson(false));
            }
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
