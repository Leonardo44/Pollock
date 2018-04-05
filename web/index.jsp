<%-- 
    Document   : index
    Created on : 04-03-2018, 04:45:01 PM
    Author     : Frank
--%>
<%@page import="sv.edu.udb.modelos.Obra_Model"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="sv.edu.udb.entidades.Obra"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%--<jsp:useBean id="obra" scope="page" class="sv.edu.udb.entidades.Obra"/>--%>
<%-- <c:set var="obras" scope="page">
    Obra_Model.obtenerObras()
</c:set> --%>
    
    <%
        List<Obra> obras = Obra_Model.obtenerObras();
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ntegrity="sha256-3edrmyuQ0w65f8gfBsqowzjJe2iM6n0nKciPUp8y+7E=" crossorigin="anonymous"></script> -->

    <script src="https://unpkg.com/masonry-layout@4/dist/masonry.pkgd.min.js"></script>    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.18.0/axios.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">

    <link rel="stylesheet" href="css/main.css">
    <script src="js/init.js"></script>

    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">

    <title>Pollock - Galería de Arte</title>
</head>

<body>
    <header>
        <nav>
            <div class="nav-wrapper deep-purple darken-4">
                <a href="/" class="brand-logo">
                    <img src="/Pollock/images/logo.png" width="50px" class="responsive-img">
                    <span>Pollock</span>
                </a>
                <a data-target="mobile-demo" class="sidenav-trigger">
                    <i class="material-icons">menu</i>
                </a>
                <ul class="right hide-on-med-and-down">
                    <li class="active">
                        <a href="/">Ver Obras</a>
                    </li>
                    <!-- <li><a href="collapsible.html">Javascript</a></li> -->
                    <!-- <li><a href="mobile.html">Mobile</a></li> -->
                </ul>
            </div>
        </nav>

        <ul class="sidenav" id="mobile-demo">
            <li class="active">
                <a href="/">Ver Obras</a>
            </li>
        </ul>
    </header>

    <main class="container">
        <h2 class="center deep-purple-text text-darken-2">Obras</h2>
        <div id="contObras" class="grid">
            <div class="grid-sizer"></div>
            <%
                if(obras.size() > 0){
                    for(Obra _o : obras){
                       %>
                       <div class="grid-item">
                            <div class="card">
                                <div class="card-image">
                                    <img src="images/obras/<%= _o.getImagen() %>">
                                </div>
                                <div class="card-content">
                                    <h5 style="font-style: italic;"><%= _o.getNombre() %></h5>
                                    <a href="/Pollock/obra.jsp?idObra=<%= _o.getIdObra() %>" class="">Ver más</a>
                                </div>
                            </div>
                        </div>
                       <% 
                    }
                }else{
                    %>
                    <h5 class="center red lighten-4 red-text text-darken-4" style="padding: 2%;">No existen registros de obras para mostrar!</h5>
                    <%
                }
            %>
        </div>
    </main>
</body>

</html>