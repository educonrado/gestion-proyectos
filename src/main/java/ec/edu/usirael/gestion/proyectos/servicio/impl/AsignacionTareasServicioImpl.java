package ec.edu.usirael.gestion.proyectos.servicio.impl;

import ec.edu.usirael.gestion.proyectos.entidades.modelo.AsignacionTareas;
import ec.edu.usirael.gestion.proyectos.entidades.repositorio.IAsignacionTareasRepositorio;
import ec.edu.usirael.gestion.proyectos.servicio.IAsignacionTareasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AsignacionTareasServicioImpl implements IAsignacionTareasServicio {

    @Autowired
    private IAsignacionTareasRepositorio asignacionRepositorio;

    @Override
    public void crear(AsignacionTareas asignacionTareas) {
        try {
            asignacionRepositorio.save(asignacionTareas);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public void actualizar(AsignacionTareas asignacionTareas) {
        try {
            asignacionRepositorio.save(asignacionTareas);
        } catch (Exception e) {
            System.err.println("Error: No se puede actualizar el objeto. " + e);
        }
    }

    @Override
    public void eliminar(int codigo) {
        try {
            asignacionRepositorio.deleteById(codigo);
        } catch (Exception e) {
            System.err.println("Error: No se puede eliminar el objeto. " + e);
        }
    }

    @Override
    public List<AsignacionTareas> listaAsignacionTareas() {
        try {
            return asignacionRepositorio.findAll();
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<AsignacionTareas> findByFechaAsignacion(LocalDate fechaAsignacion) {
        try {
            return asignacionRepositorio.findByFechaAsignacion(fechaAsignacion);

        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<AsignacionTareas> listadoTareasEntreRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        try {
            return asignacionRepositorio.listadoTareasEntreRangoFechas(fechaInicio, fechaFin);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public int numeroTareasPorProyecto(int codigoProyecto) {
        try {
            return asignacionRepositorio.numeroTareasPorProyecto(codigoProyecto);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener numero de tareas. " + e);
            return 0;
        }
    }

    @Override
    public List<AsignacionTareas> listadoTareasPorUsuario(int codigoUsuario) {
        try {
            return asignacionRepositorio.listadoTareasPorUsuario(codigoUsuario);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<String> mostrarEquipoDeProyecto(int codigoProyecto) {
        try {
            return asignacionRepositorio.mostrarEquipoDeProyecto(codigoProyecto);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

	public Optional<AsignacionTareas> obtenerAsignacionPorCodigo(int id) {
		try {
            return asignacionRepositorio.findById(id);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
	}
}
