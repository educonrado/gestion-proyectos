package ec.edu.usirael.gestion.proyectos;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import ec.edu.usirael.gestion.proyectos.entidades.enumerador.PrioridadEnum;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.*;
import ec.edu.usirael.gestion.proyectos.servicio.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class GestionDeProyectosApplicationTests {

    @Autowired
    private ITareaServicio tareaServicio;

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @Autowired
    private IProyectoServicio proyectoServicio;

    @Autowired
    private IAsignacionTareasServicio asignacionTareasServicio;

    @Autowired
    private IHistorialAccionesTareaServicio historialAccionesTareaServicio;

    @Test
    void contextLoads() {
        Proyecto proyecto = new Proyecto();

        proyecto.setNombre("Managment education");
        proyecto.setDescripcion("Proyecto de manejo de sistema educativo");
        proyecto.setFechaFin(LocalDate.of(2024, 12, 31));
        proyecto.setFechaInicio(LocalDate.now());
        proyecto.setPresupuesto(5612.23);

        proyectoServicio.crear(proyecto);

        Tarea tarea = new Tarea();
        tarea.setNombre("Tarea 3");
        tarea.setDescripcion("Preparar ambiente de desarrollo");
        tarea.setEstado(EstadoEnum.PENDIENTE);
        tarea.setFechaInicio(LocalDate.now());
        tarea.setFechaFin(LocalDate.of(2024, 12, 31));
        tarea.setPrioridad(PrioridadEnum.MEDIO);
        tarea.setProyecto(proyecto);

        tareaServicio.crear(tarea);


        Usuario usuario = new Usuario();
        usuario.setCorreo("excz@gmail.com");
        usuario.setNombre("Eduardo");
        usuario.setEstado(true);

        usuarioServicio.crear(usuario);

        AsignacionTareas asignacionTareas = new AsignacionTareas();
        asignacionTareas.setFechaAsignacion(LocalDate.now());
        asignacionTareas.setTarea(tarea);
        asignacionTareas.setUsuario(usuario);

        asignacionTareasServicio.crear(asignacionTareas);

        HistorialAccionesTarea historialAccionesTarea = new HistorialAccionesTarea();
        historialAccionesTarea.setAsignacion(asignacionTareas);
        historialAccionesTarea.setEstadoActual(EstadoEnum.PENDIENTE);
        historialAccionesTarea.setEstadoAnterior(null);
        historialAccionesTarea.setFechaActualizacion(LocalDate.now());
        historialAccionesTarea.setDetalles("Creacion de actividad");

        historialAccionesTareaServicio.crear(historialAccionesTarea);


        historialAccionesTarea = new HistorialAccionesTarea();
        historialAccionesTarea.setAsignacion(asignacionTareas);
        historialAccionesTarea.setEstadoActual(EstadoEnum.PROGRESO);
        historialAccionesTarea.setEstadoAnterior(EstadoEnum.PENDIENTE);
        historialAccionesTarea.setFechaActualizacion(LocalDate.of(2024, 11, 3));
        historialAccionesTarea.setDetalles("Inicio de creacion de servidor");

        historialAccionesTareaServicio.crear(historialAccionesTarea);

        System.out.print("Historial de acciones por estado: ");
        System.out.println(historialAccionesTareaServicio.findByEstadoActual(EstadoEnum.PENDIENTE).size());

        System.out.print("Listado tareas entre rango de fechas: ");
        System.out.println(asignacionTareasServicio.listadoTareasEntreRangoFechas(LocalDate.of(2024, 11, 12), LocalDate.of(2024, 11, 15)).size());

        System.out.print("Listado actividades en progreso por usuario: \n[");
        historialAccionesTareaServicio.listadoActividadesEnProgresoPorUsuario(usuario.getCodigo()).forEach(System.out::println);
        System.out.println("]");

        System.out.print("Listado equipo por proyecto: ");
        asignacionTareasServicio.mostrarEquipoDeProyecto(proyecto.getCodigo()).forEach(System.out::println);

        System.out.print("Listado tareas por proyecto: ");
        List<Tarea> tareas = tareaServicio.listadoTareasPorProyecto(proyecto.getCodigo());
        for (Tarea t : tareas) {
            System.out.println(String.format("Tarea: [%s]", t.getNombre()));
        }

    }

}
