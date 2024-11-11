package ec.edu.usirael.gestion.proyectos.entidades.repositorio;

import ec.edu.usirael.gestion.proyectos.entidades.modelo.AsignacionTareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IAsignacionTareasRepositorio extends JpaRepository<AsignacionTareas, Integer> {

    public List<AsignacionTareas> findByFechaAsignacion(LocalDate fechaAsignacion);

    @Query("select a from AsignacionTareas a where a.fechaAsignacion between ?1 and ?2 ")
    public List<AsignacionTareas> listadoTareasEntreRangoFechas(LocalDate fechaInicio, LocalDate fechaFin);

    @Query("select count(a) from AsignacionTareas a where a.tarea.codigo = ?1 ")
    public int numeroTareasPorProyecto(int codigoProyecto);

    @Query("select a from AsignacionTareas a where a.usuario.codigo = ?1 ")
    public List<AsignacionTareas> listadoTareasPorUsuario(int codigoUsuario);

    @Query("select distinct(u.nombre) from AsignacionTareas a join Usuario u on u.codigo = a.usuario.codigo " +
            "join Tarea t on t.codigo = a.tarea.codigo " +
            "join Proyecto p on p.codigo = t.proyecto.codigo " +
            "where p.codigo = ?1 ")
    public List<String> mostrarEquipoDeProyecto(int codigoProyecto);
}
