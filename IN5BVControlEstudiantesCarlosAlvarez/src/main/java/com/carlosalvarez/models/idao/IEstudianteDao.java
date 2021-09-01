package com.carlosalvarez.models.idao;

import com.carlosalvarez.models.domain.Estudiante;
import java.util.List;

/**
 *
 * @author Carlos Adolfo Alvarez Crúz
 */
public interface IEstudianteDao {
    
    public List<Estudiante> listar();
    
    public Estudiante encontrar(Estudiante estudiante);
    
    public int insertar(Estudiante estudiante);
    
    public int actualizar(Estudiante estudiante);
    
    public int eliminar(Estudiante estudiante);
    
}
