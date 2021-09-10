<%-- 
    Document   : index
    Created on : 25/08/2021, 02:20:34 PM
    Author     : Carlos Adolfo Alvarez Crúz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <title>Control Estudiante -Inicio</title>
    </head>
    <body>
        <!-- Cabecera Header-nav-->
        
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>

        <main>
            <section id = "contenido">
                <p class="descripcion">Kinal es un Centro Educativo privado, no lucrativo, dirigido a la formación técnica profesional de jóvenes y adultos, de beneficio colectivo y asistencia social en favor de los sectores más necesitados de la comunidad.<p>

                    <img id="imagen-principal" src="./assets/images/principal.png">

                <p class="descripcion">Nuestro valor fundamental es enseñar a realizar el trabajo bien hecho, que sea la base de la superación de alumnos y el medio para servir a los demás.</p>
                <br>


            </section>
        </main>

        <!--Pie de pagina-->
        
        <jsp:include page="/WEB-INF/paginas/comunes/pie-pagina.jsp"/>

        <script src="./assets/js/jquery-3.6.0.js"></script> 
        <script src="./assets/js/bootstrap.bundle.js"></script>

    </body>
</html>
