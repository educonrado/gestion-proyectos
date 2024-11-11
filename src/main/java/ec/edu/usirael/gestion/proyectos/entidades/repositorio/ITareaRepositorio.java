package ec.edu.usirael.gestion.proyectos.entidades.repositorio;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Tarea;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITareaRepositorio extends JpaRepository<Tarea, Integer> {

    public List<Tarea> findByEstado(EstadoEnum estado);

    @Query("select t from Tarea t where t.progreso >= ?1")
    public List<Tarea> listadoTareasMayoresAPorcentajeAvance(int avance);

    public List<Tarea> findByNombreAndEstado(String nombre, EstadoEnum estado);

    @Query("select t from Tarea t where t.fechaInicio > ?1")
    public List<Tarea> listadoTareasPorFechaInicio(LocalDate fechaInicio);

    @Query("select t from Tarea t join Proyecto p on p.codigo = t.proyecto.codigo where p.codigo = ?1 ")
    public List<Tarea> listadoTareasPorProyecto(int codigoProyecto);

}
