<%-- 
    Document   : estudiante
    Created on : 25/08/2021, 03:11:19 PM
    Author     : Carlos Adolfo Alvarez Crúz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
        <!-- Bootstrap CSS --> 
        <link rel="stylesheet" href="../assets/css/bootstrap.css">

        <title>Listado de estudiantes</title>
    </head>
    <body>

        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>

        <header id="main-header" class="py-2 bg-light pt-4">
            <div class="container">
                <div class="row">
                    <div class="col-9">
                        <h1 class="text-center">
                            <i class="fas fa-cog"></i> Control Estudiantes
                        </h1>
                    </div>
                </div>
            </div>
        </header>

        <section id="acciones" class="py-4 mb-4">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-3">
                        <a id ="btn-agregar-estudiante" data-bs-toggle="modal" data-bs-target="#agregar-estudiante-modal" class="btn btn-primary  btn-block">
                            <i class="fas fa-plus"> Agregar registro</i>
                        </a>
                    </div>
                </div>
            </div>
        </section>

        <!-- Button trigger modal -->

        <!-- Modal -->
        <div class="modal fade" id="agregar-estudiante-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-primary text-white">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar estudiante</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletEstudiante">
                        <div class="modal-body">

                            <div class="mb-3">
                                <label for="nombre" class="form-label">Nombre</label>
                                <input type="text" id="nombre" name="nombre" class="form-control"/>
                            </div>
                            
                            <div class="mb-3">
                                <label for="apellido" class="form-label">Apellido</label>
                                <input type="text" id="apellido" name="apellido" class="form-control"/>
                            </div>
                            
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" id="email" name="email" class="form-control"/>
                            </div>
                            
                            <div class="mb-3">
                                <label for="telefono" class="form-label">Teléfono</label>
                                <input type="tel" id="telefono" name="telefono" class="form-control"/>
                            </div>
                            
                            <div class="mb-3">
                                <label for="saldo" class="form-label">Saldo</label>
                                <input type="number" id="saldo" name="saldo" class="form-control" step="any"/>
                            </div>
                            
                            <input type="hidden" name="accion" value="insertar"/>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-success">Guardar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <section id="estudiantes" class="mt-5 mb-5">
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

                                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletEstudiante?accion=editar&idEstudiante=${estudiante.idEstudiante}">Editar
                                                <i class="fas fa-pen-to-square"></i>
                                            </a>

                                        </td>

                                        <td>
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletEstudiante?accion=eliminar&idEstudiante=${estudiante.idEstudiante}">Eliminar
                                                <i class="fas fa-trash"></i>
                                            </a>

                                        </td> 


                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>    
                    </div>

                    <div class="col-xs-12 col-md-3">
                        <div class="row">
                            <div class="card text-center bg-danger text-black mb-3">
                                <div class="card-body">
                                    <h3>Saldo Total</h3>
                                    <h4 class="display-4"> 
                                        <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                                    </h4>
                                </div>
                            </div>
                        </div>


                        <div class="row pb-5">
                            <div class="card text-center bg-warning text-black mb-3">
                                <div class="card-body">
                                    <h3>Total Estudiantes</h3>
                                    <h4 class="display-4"> 
                                        ${cantidadEstudiantes}
                                    </h4>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </section>



        <jsp:include page="../WEB-INF/paginas/comunes/pie-pagina.jsp"/>

        <script src="../assets/js/jquery-3.6.0.js"></script>
        <script src="../assets/js/bootstrap.bundle.js"></script>
    </body>
</html>