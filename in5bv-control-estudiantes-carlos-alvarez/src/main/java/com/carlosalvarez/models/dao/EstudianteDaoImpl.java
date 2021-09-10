/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlosalvarez.models.dao;

import com.carlosalvarez.db.Conexion;
import com.carlosalvarez.models.domain.Estudiante;
import com.carlosalvarez.models.idao.IEstudianteDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Adolfo Alvarez Crúz
 * @date 19/08/2021
 * @time 05:30:49 PM Codigo tecnico: IN5BV
 */
public class EstudianteDaoImpl implements IEstudianteDao {

    private static final String SQL_SELECT = "SELECT * FROM estudiante";
    private static final String SQL_DELETE = "DELETE FROM estudiante WHERE id_estudiante = ?";
    private static final String SQL_INSERT = "INSERT INTO estudiante(nombre, apellido, email, telefono, saldo) values (?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT id_estudiante, nombre, apellido, email, telefono, saldo FROM estudiante WHERE id_estudiante = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Estudiante estudiante = null;
    List<Estudiante> listaEstudiantes = new ArrayList<>();

    @Override
    public List<Estudiante> listar() {

        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int idEstudiante = rs.getInt("id_estudiante");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                estudiante = new Estudiante(idEstudiante, nombre, apellido, email, telefono, saldo);

                listaEstudiantes.add(estudiante);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return listaEstudiantes;
    }

    @Override
    public Estudiante encontrar(Estudiante estudiante) {
        
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_BY_ID); //Primer cambio
            //Segundo cambio
            pstmt.setInt(1, estudiante.getIdEstudiante());
            
            System.out.println(pstmt.toString());
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                //Tercer cambio
                
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
                estudiante.setEmail(email);
                estudiante.setTelefono(telefono);

                listaEstudiantes.add(estudiante);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return estudiante;
    }

    @Override
    public int insertar(Estudiante estudiante) {

        int rows = 0;

        try {

            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, estudiante.getNombre());
            pstmt.setString(2, estudiante.getApellido());
            pstmt.setString(3, estudiante.getEmail());
            pstmt.setString(4, estudiante.getTelefono());
            pstmt.setDouble(5, estudiante.getSaldo());

            System.out.println(pstmt.toString());

            rows = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int actualizar(Estudiante estudiante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Estudiante estudiante) {
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, estudiante.getIdEstudiante());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(conn);
        }
        return rows;
    }

}
