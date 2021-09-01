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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "listar":
                    listarEstudiantes(request, response);
                    break;
                case "editar":
                    //.......
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
        response.sendRedirect("estudiantes/listarEstudiantes.jsp");
    }

    public double getSaldoTotal() {

        //List<Estudiante> lista = (List<Estudiante>) new EstudianteDaoImpl();
        List<Estudiante> lista = (List<Estudiante>) new EstudianteDaoImpl().listar();
        
        double total = 0.00;
        
        for(Estudiante e : lista){
            total += e.getSaldo();
        }

        return total;
    }

    public int getEstudiantes(){
        
        List<Estudiante> lista = (List<Estudiante>) new EstudianteDaoImpl().listar();
        return lista.size();
    }


}
