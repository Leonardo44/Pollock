<%-- 
    Document   : obra
    Created on : 04-04-2018, 05:13:23 PM
    Author     : Frank
--%>
<%@page import="sv.edu.udb.entidades.Obra"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var = "idObra" scope = "page" value = "${param.idObra}"/>

<c:if test = "${empty idObra}">
    <c:redirect url = "/Pollock/"/>
</c:if>

<%
    Obra _o = new Obra(request.getParameter("idObra"), true);
    
    if(_o.getIdObra() == null){
        response.sendRedirect("/Pollock/");
    }else{
 %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
        
            <!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ntegrity="sha256-3edrmyuQ0w65f8gfBsqowzjJe2iM6n0nKciPUp8y+7E=" crossorigin="anonymous"></script> -->
        
            <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.18.0/axios.min.js"></script>
        
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
        
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
            <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
        
            <link rel="stylesheet" href="css/main.css">
            <script src="js/init.js"></script>
            <script src="js/main.js"></script>
        
            <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        
            <title>Pollock - Obra</title>
    </head>
    <body>
        <header>
            <nav>
                <div class="nav-wrapper deep-purple darken-4">
                    <a href="/Pollock" class="brand-logo">
                        <img src="/Pollock/images/logo.png" width="50px" class="responsive-img">
                        <span>Pollock</span>
                    </a>
                    <a data-target="mobile-demo" class="sidenav-trigger">
                        <i class="material-icons">menu</i>
                    </a>
                    <ul class="right hide-on-med-and-down">
                        <li>
                            <a href="/Pollock/">Ver Obras</a>
                        </li>
                        <!-- <li><a href="collapsible.html">Javascript</a></li> -->
                        <!-- <li><a href="mobile.html">Mobile</a></li> -->
                    </ul>
                </div>
            </nav>
    
            <ul class="sidenav" id="mobile-demo">
                <li>
                    <a href="/Pollock/">Ver Obras</a>
                </li>
            </ul>
        </header>
        <main class="container row">
            <input type="hidden" name="idObra" id="idObra" value="<%= _o.getIdObra() %>">
            <h2 class="center deep-purple-text text-darken-2">Obra</h2>
            
            <div id="obraCont">
                <div class="img col s12 m6 l6">
                    <img id="_img" src="images/obras/<%= _o.getImagen() %>" class="responsive-img materialboxed" data-caption="<%= _o.getNombre() %>">
                </div>
                <div class="img col s12 m6 l6">
                    <h5>Nombre</h5>
                    <p><%= _o.getNombre() %></p>
                    <hr>
                    <h5>Autor</h5>
                    <p style="text-align: justify;">
                        <%= _o.getAutor().getNombres() + " " + _o.getAutor().getApellidos() %>
                    </p>
                    <hr>
                    <h5>Puntaje</h5>
                    <p style="font-size: 2em"><b><span class="<%= _o.getCalificacion() > 2.5 ? "green" : "red"  %>-text" id="rate"><%= _o.getCalificacion() %></span> / 5.00</b></p>
                    <hr>
                    <h5>Votar</h5>
                    <x-rating id="rating"></x-rating>
                    <hr>
                </div>
            </div>
            <div class="col s12">
                <h5>Descripción</h5>
                <p id="descripcion" style="text-align: justify;"><%= _o.getDescripcion()%></p>
                <a id="btnLeer" class="deep-purple darken-4 btn waves-effect waves-light"><i class="material-icons left">graphic_eq</i>Leer</a>
                <hr>
            </div>
        </main>

        <script src="js/Rating.js"></script>
    </body>
</html>
<%
    }
%>



