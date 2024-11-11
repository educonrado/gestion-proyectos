package ec.edu.usirael.gestion.proyectos.entidades.repositorio;

import ec.edu.usirael.gestion.proyectos.entidades.modelo.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IProyectoRepositorio extends JpaRepository<Proyecto, Integer> {

    @Query("select p from Proyecto p, Tarea t where p.codigo=t.proyecto.codigo")
    public List<Proyecto> listadoProyectoTareasActivas();

    @Query("select p from Proyecto p where p.presupuesto >= ?1")
    public List<Proyecto> findByPresupuestoMin(double prespuesto);

    @Query("select count(t) from Proyecto p, Tarea t where p.codigo=t.proyecto.codigo and p.codigo = ?1")
    public int numeroTareasEnProyecto(int codigo);

    @Query("select p from Proyecto p where p.fechaInicio >= ?1")
    public List<Proyecto> listadoProyectosFechaInicioMayorAFecha(LocalDate fechaInicio);

    @Query("select p from Proyecto p where p.fechaInicio <= ?1")
    public List<Proyecto> listadoProyectosFechaFinMenorAFecha(LocalDate fechaFin);

}
