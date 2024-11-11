package ec.edu.usirael.gestion.proyectos.servicio.impl;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Tarea;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Usuario;
import ec.edu.usirael.gestion.proyectos.entidades.repositorio.ITareaRepositorio;
import ec.edu.usirael.gestion.proyectos.servicio.ITareaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TareaServicioImpl implements ITareaServicio {

    @Autowired
    private ITareaRepositorio tareaRepositorio;

    @Override
    public void crear(Tarea tarea) {
        try {
            tareaRepositorio.save(tarea);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public void actualizar(Tarea tarea) {
        try {
            tareaRepositorio.save(tarea);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public void eliminar(int codigo) {
        try {
            tareaRepositorio.deleteById(codigo);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public List<Tarea> listaTareas() {
        try {
            return tareaRepositorio.findAll();
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Tarea> findByEstado(EstadoEnum estado) {
        try {
            return tareaRepositorio.findByEstado(estado);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Tarea> listadoTareasMayoresAPorcentajeAvance(int avance) {
        try {
            return tareaRepositorio.listadoTareasMayoresAPorcentajeAvance(avance);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Tarea> findByUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Tarea> findByNombreAndEstado(String nombre, EstadoEnum estado) {
        try {
            return tareaRepositorio.findByNombreAndEstado("Lina", estado);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Tarea> listadoTareasPorFechaInicio(LocalDate fechaInicio) {
        try {
            return tareaRepositorio.listadoTareasPorFechaInicio(fechaInicio);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Tarea> listadoTareasPorProyecto(int codigoProyecto) {
        try {
            return tareaRepositorio.listadoTareasPorProyecto(codigoProyecto);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }
}
