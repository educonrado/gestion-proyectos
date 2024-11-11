package ec.edu.usirael.gestion.proyectos.servicio;

import ec.edu.usirael.gestion.proyectos.entidades.modelo.Proyecto;

import java.time.LocalDate;
import java.util.List;

public interface IProyectoServicio {

    public void crear(Proyecto proyecto);

    public void actualizar(Proyecto proyecto);

    public void eliminar(int codigo);

    public List<Proyecto> listaProyectos();

    public List<Proyecto> listadoProyectoTareasActivas();

    public List<Proyecto> findByPresupuestoMin(double prespuesto);

    public int numeroTareasEnProyecto(int codigo);

    public List<Proyecto> listadoProyectosFechaInicioMayorAFecha(LocalDate fechaInicio);

    public List<Proyecto> listadoProyectosFechaFinMenorAFecha(LocalDate fechaFin);
}
