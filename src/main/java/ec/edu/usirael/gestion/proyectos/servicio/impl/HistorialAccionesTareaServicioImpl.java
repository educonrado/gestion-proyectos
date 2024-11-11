package ec.edu.usirael.gestion.proyectos.servicio.impl;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.HistorialAccionesTarea;
import ec.edu.usirael.gestion.proyectos.entidades.repositorio.IHistorialAccionesTareaRepositorio;
import ec.edu.usirael.gestion.proyectos.servicio.IHistorialAccionesTareaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistorialAccionesTareaServicioImpl implements IHistorialAccionesTareaServicio {

    @Autowired
    private IHistorialAccionesTareaRepositorio historialRepositorio;

    @Override
    public void crear(HistorialAccionesTarea historialAccionesTarea) {
        try {
            historialRepositorio.save(historialAccionesTarea);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public void actualizar(HistorialAccionesTarea historialAccionesTarea) {
        try {
            historialRepositorio.save(historialAccionesTarea);
        } catch (Exception e) {
            System.err.println("Error: No se puede actualizar el objeto. " + e);
        }
    }

    @Override
    public void eliminar(int codigo) {
        try {
            historialRepositorio.deleteById(codigo);
        } catch (Exception e) {
            System.err.println("Error: No se puede actualizar el objeto. " + e);
        }
    }

    @Override
    public List<HistorialAccionesTarea> listarHistorialAccionesTarea() {
        try {
            return historialRepositorio.findAll();
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<HistorialAccionesTarea> findByFechaActualizacion(LocalDate fechaActualizacion) {
        try {
            return historialRepositorio.findByFechaActualizacion(fechaActualizacion);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<HistorialAccionesTarea> findByEstadoActual(EstadoEnum estado) {
        try {
            return historialRepositorio.findByEstadoActual(estado);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<HistorialAccionesTarea> listadoPorDetalles(String detalles) {
        try {
            return historialRepositorio.listadoPorDetalles(detalles);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public int numeroActividadesPorTarea(int codigoTarea) {
        try {
            return historialRepositorio.numeroActividadesPorTarea(codigoTarea);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener numero de actividades. " + e);
            return 0;
        }
    }

    @Override
    public List<String> listadoActividadesEnProgresoPorUsuario(int codigoUsuario) {
        try {
            return historialRepositorio.listadoActividadesEnProgresoPorUsuario(codigoUsuario);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener numero de actividades. " + e);
            return null;
        }
    }
}
