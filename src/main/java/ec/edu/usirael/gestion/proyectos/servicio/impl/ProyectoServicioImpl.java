package ec.edu.usirael.gestion.proyectos.servicio.impl;

import ec.edu.usirael.gestion.proyectos.entidades.modelo.Proyecto;
import ec.edu.usirael.gestion.proyectos.entidades.repositorio.IProyectoRepositorio;
import ec.edu.usirael.gestion.proyectos.servicio.IProyectoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServicioImpl implements IProyectoServicio {

    @Autowired
    private IProyectoRepositorio proyectoRepositorio;

    @Override
    public void crear(Proyecto proyecto) {
        try {
            proyectoRepositorio.save(proyecto);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public void actualizar(Proyecto proyecto) {
        try {
            proyectoRepositorio.save(proyecto);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public void eliminar(int codigo) {
        try {
            proyectoRepositorio.deleteById(codigo);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public List<Proyecto> listaProyectos() {
        try {
            return proyectoRepositorio.findAll();
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Proyecto> listadoProyectoTareasActivas() {
        try {
            return proyectoRepositorio.listadoProyectoTareasActivas();
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Proyecto> findByPresupuestoMin(double prespuesto) {
        try {
            return proyectoRepositorio.findByPresupuestoMin(prespuesto);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public int numeroTareasEnProyecto(int codigo) {
        try {
            return proyectoRepositorio.numeroTareasEnProyecto(codigo);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener numero de tareas. " + e);
            return 0;
        }
    }

    @Override
    public List<Proyecto> listadoProyectosFechaInicioMayorAFecha(LocalDate fechaInicio) {
        try {
            return proyectoRepositorio.listadoProyectosFechaInicioMayorAFecha(fechaInicio);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Proyecto> listadoProyectosFechaFinMenorAFecha(LocalDate fechaFin) {
        try {
            return proyectoRepositorio.listadoProyectosFechaFinMenorAFecha(fechaFin);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

	@Override
	public Optional<Proyecto> obtenerProyectoPorCodigo(int codigo) {
		try {
			return proyectoRepositorio.findById(codigo);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
	}
}
