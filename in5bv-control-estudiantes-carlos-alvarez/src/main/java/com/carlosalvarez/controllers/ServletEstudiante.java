/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosalvarez.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import java.util.List;
import com.carlosalvarez.models.dao.EstudianteDaoImpl;
import com.carlosalvarez.models.domain.Estudiante;
import com.carlosalvarez.db.Conexion;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos Adolfo Alvarez Crúz
 * @date 25/08/2021
 * @time 01:54:34 PM Codigo tecnico: IN5BV
 */
@WebServlet("/ServletEstudiante")
public class ServletEstudiante extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        System.out.println("Accion:  " + accion);

        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarEstudiante(request, response);
                    break;
            }
        }

    }

    private void insertarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Recuperar los valores del formulario agregar estudiante
        /*
        //Una opcion para agregar datos desde el onstructor nulo
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(request.getParameter("nombre"));
        estudiante.setApellido(request.getParameter("apellido"));
        estudiante.setEmail(request.getParameter("email"));
        estudiante.setTelefono(request.getParameter("telefono"));

        if ((request.getParameter("saldo") != null) && (!request.getParameter("saldo").equals("")) ) {
            estudiante.setSaldo(Double.parseDouble(request.getParameter("saldo")));
        }
        System.out.println(estudiante);
         */

        //otra opcion para construir el objeto Estudiantes
        // a partir del contructor con parametros
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        Double saldo = 0.0;

        if ((request.getParameter("saldo") != null) && (!request.getParameter("saldo").equals(""))) {
            saldo = Double.parseDouble(request.getParameter("saldo"));
        }

        //Crear objeto estudiante utilizando en Bean
        Estudiante estudiante = new Estudiante(nombre, apellido, email, telefono, saldo);

        System.out.println(estudiante);

        //Insertar el nuevo objeto a la base de datos
        int registrosIngresados = new EstudianteDaoImpl().insertar(estudiante);

        //Redirigimos hacia listar estudiantes..
        listarEstudiantes(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarEstudiantes(request, response);
                    break;
                case "editar":
                    editarEstudiante(request, response);
                    break;
                case "eliminar":
                    eliminarEstudiante(request, response);
                    break;
            }
        }
    }

    private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Recuperar el id del estudiante
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));

        //Crear objeto de tipo estudiante
        Estudiante estudiante = new Estudiante(idEstudiante);

        //llamar al metodo eliminar
        int registrosEliminados = new EstudianteDaoImpl().eliminar(estudiante);

        System.out.println("Cantidad de registros elimindos " + registrosEliminados);

        //volvemos a llamr la tabla ya actualizada
        listarEstudiantes(request, response);
    }

    private void listarEstudiantes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Estudiante> listaEstudiantes = new EstudianteDaoImpl().listar();

        HttpSession sesion = request.getSession();
        sesion.setAttribute("listadoEstudiantes", listaEstudiantes);
        sesion.setAttribute("saldoTotal", getSaldoTotal());
        sesion.setAttribute("cantidadEstudiantes", getEstudiantes());
        response.sendRedirect("estudiantes/estudiantes.jsp");
    }

    private void editarEstudiante(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Recuperear el id

        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        
        //Objeto de tipo estudiante
        Estudiante estudiante = new EstudianteDaoImpl().encontrar(new Estudiante(idEstudiante));
        
        System.out.println(estudiante);
        
        request.setAttribute("estudiante", estudiante);
        
        //Redireccioner a un JSP
        
        request.getRequestDispatcher("estudiantes/editar-estudiante.jsp").forward(request, response);

    }

    public double getSaldoTotal() {

        //List<Estudiante> lista = (List<Estudiante>) new EstudianteDaoImpl();
        List<Estudiante> lista = (List<Estudiante>) new EstudianteDaoImpl().listar();

        double total = 0.00;

        for (Estudiante e : lista) {
            total += e.getSaldo();
        }

        return total;
    }

    public int getEstudiantes() {

        List<Estudiante> lista = (List<Estudiante>) new EstudianteDaoImpl().listar();
        return lista.size();
    }

}
