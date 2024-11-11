package ec.edu.usirael.gestion.proyectos.entidades.repositorio;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.HistorialAccionesTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IHistorialAccionesTareaRepositorio extends JpaRepository<HistorialAccionesTarea, Integer> {
    public List<HistorialAccionesTarea> findByFechaActualizacion(LocalDate localDate);

    public List<HistorialAccionesTarea> findByEstadoActual(EstadoEnum estado);

    @Query("select h from HistorialAccionesTarea h where h.detalles like ?1 ")
    public List<HistorialAccionesTarea> listadoPorDetalles(String detalles);

    @Query("select count(h) from HistorialAccionesTarea h where h.asignacion.codigo = ?1 ")
    public int numeroActividadesPorTarea(int codigoTarea);

    @Query("select h.detalles  from HistorialAccionesTarea h join AsignacionTareas a on h.asignacion.codigo = a.codigo " +
            "join Usuario u on a.usuario.codigo = u.codigo where u.codigo = ?1 and h.estadoActual = PROGRESO")
    public List<String> listadoActividadesEnProgresoPorUsuario(int codigoUsuario);
}
