package ec.edu.usirael.gestion.proyectos.servicio;

import ec.edu.usirael.gestion.proyectos.entidades.modelo.AsignacionTareas;

import java.time.LocalDate;
import java.util.List;

public interface IAsignacionTareasServicio {

    public void crear(AsignacionTareas asignacionTareas);

    public void actualizar(AsignacionTareas asignacionTareas);

    public void eliminar(int codigo);

    public List<AsignacionTareas> listaAsignacionTareas();

    public List<AsignacionTareas> findByFechaAsignacion(LocalDate fechaAsignacion);

    public List<AsignacionTareas> listadoTareasEntreRangoFechas(LocalDate fechaInicio, LocalDate fechaFin);

    public int numeroTareasPorProyecto(int codigoProyecto);

    public List<AsignacionTareas> listadoTareasPorUsuario(int codigoUsuario);

    public List<String> mostrarEquipoDeProyecto(int codigoProyecto);
}
