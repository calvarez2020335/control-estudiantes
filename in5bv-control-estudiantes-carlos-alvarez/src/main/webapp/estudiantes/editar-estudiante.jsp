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
        <link rel="stylesheet" type="text/css" href="./assets/css/style.css">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js"></script>
        <!-- Bootstrap CSS --> 
        <link rel="stylesheet" href="./assets/css/bootstrap.css">

        <title>Editar estudiantes</title>
    </head>
    <body>

        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>


        <section id="action" class="py-4 mb-4 bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-md-3" >
                        <a href="${pageContext.request.contextPath}/estudiantes.jsp" class="btn btn-light btn-block">
                            <i class="fa fa-arrow-left"></i>Regresar a estudiantes 
                        </a> 
                    </div>
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-3">

                    </div>
                </div>
            </div>
        </section>

        <!-- Button trigger modal -->

        <!-- Modal -->

        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">

                                <h4>Editar Estudiante</h4>

                                <div class="card-body">

                                    <form method="POST" action="${pageContext.request.contextPath}/ServletEstudiante">

                                        <div class="mb-3">
                                            <label for="nombre" class="form-label">Nombre</label>
                                            <input type="text" id="nombre" name="nombre" class="form-control" value="${estudiante.nombre}"/>
                                        </div>

                                        <div class="mb-3">
                                            <label for="apellido" class="form-label">Apellido</label>
                                            <input type="text" id="apellido" name="apellido" class="form-control" value="${estudiante.apellido}"/>
                                        </div>

                                        <div class="mb-3">
                                            <label for="email" class="form-label">Email</label>
                                            <input type="email" id="email" name="email" class="form-control" value="${estudiante.email}"/>
                                        </div>

                                        <div class="mb-3">
                                            <label for="telefono" class="form-label">Teléfono</label>
                                            <input type="tel" id="telefono" name="telefono" class="form-control" value="${estudiante.telefono}"/>
                                        </div>

                                        <div class="mb-3">
                                            <label for="saldo" class="form-label">Saldo</label>
                                            <input type="number" id="saldo" name="saldo" class="form-control" step="any" value="${estudiante.saldo}"/>
                                        </div>

                                        <input type="hidden" name="accion" value="actualizar"/>

                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                                        <button type="submit" class="btn btn-success">Guardar</button>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>


        <jsp:include page="../WEB-INF/paginas/comunes/pie-pagina.jsp"/>

        <script src="./assets/js/jquery-3.6.0.js"></script>
        <script src="./assets/js/bootstrap.bundle.js"></script>
    </body>
</html>