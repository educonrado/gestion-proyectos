package ec.edu.usirael.gestion.proyectos.servicio;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Tarea;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITareaServicio {
    public void crear(Tarea tarea);

    public void actualizar(Tarea tarea);

    public void eliminar(int codigo);

    public List<Tarea> listaTareas();

    public List<Tarea> findByEstado(EstadoEnum estado);

    public List<Tarea> listadoTareasMayoresAPorcentajeAvance(int avance);

    public List<Tarea> findByUsuario(Usuario usuario);

    public List<Tarea> findByNombreAndEstado(String nombre, EstadoEnum estado);

    public List<Tarea> listadoTareasPorFechaInicio(LocalDate fechaInicio);

    public List<Tarea> listadoTareasPorProyecto(int codigoProyecto);
    
    public Optional<Tarea> obtenerTareaPorCodigo(int id);
}
