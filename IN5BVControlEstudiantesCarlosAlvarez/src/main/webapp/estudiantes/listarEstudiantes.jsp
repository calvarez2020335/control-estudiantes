<%-- 
    Document   : estudiante
    Created on : 25/08/2021, 03:11:19 PM
    Author     : Carlos Adolfo Alvarez Crúz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="../assets/css/bootstrap.css"> 

        <title>Listado de estudiantes</title>
    </head>
    <body>

        <header id="main-header" class="py-2 bg-info text-white">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1>
                            Control de estudiantes
                        </h1>
                    </div>
                </div>
            </div>
        </header>

        <section id="estudianters">
            <div class="container">

                <div class="row">
                    <div class="col-9">
                        <table class="table table-striped">
                            <thead class="table-dark">
                                <tr>
                                    <th>#</th>
                                    <th>Nombre Completo</th>
                                    <th>Saldo</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="estudiante" items="${listadoEstudiantes}">
                                    <tr>
                                        <td>${estudiante.idEstudiante}</td>
                                        <td>${estudiante.nombre} ${estudiante.apellido}</td>
                                        <td>${estudiante.saldo}</td>
                                        <td>

                                            <a href="${pageContext.request.contextPath}/ServletEstudiante?accion=eliminar&idEstudiante=${estudiante.idEstudiante}">Eliminar</a>

                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>

                        </table>
                    </div>
                    <div class="col-3">
                        <div class="card-body">
                            <h3>Saldo Total</h3>
                            <h4>${saldoTotal}</h4>
                            <h3>Cantidad Estudiantes</h3>
                            <h4>${cantidadEstudiantes}</h4>
                        </div>
                    </div>
                </div>

            </div>
        </section>

        <script src="../assets/js/jquery-3.6.0.js"></script> 
        <script src="../assets/js/bootstrap.bundle.js"></script>


    </body>
</html>
