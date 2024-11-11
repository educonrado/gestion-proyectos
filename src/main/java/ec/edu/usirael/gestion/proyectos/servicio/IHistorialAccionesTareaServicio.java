package ec.edu.usirael.gestion.proyectos.servicio;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.HistorialAccionesTarea;

import java.time.LocalDate;
import java.util.List;

public interface IHistorialAccionesTareaServicio {

    public void crear(HistorialAccionesTarea historialAccionesTarea);

    public void actualizar(HistorialAccionesTarea historialAccionesTarea);

    public void eliminar(int codigo);

    public List<HistorialAccionesTarea> listarHistorialAccionesTarea();

    public List<HistorialAccionesTarea> findByFechaActualizacion(LocalDate localDate);

    public List<HistorialAccionesTarea> findByEstadoActual(EstadoEnum estado);

    public List<HistorialAccionesTarea> listadoPorDetalles(String detalles);

    public int numeroActividadesPorTarea(int codigoTarea);

    public List<String> listadoActividadesEnProgresoPorUsuario(int codigoUsuario);
}
