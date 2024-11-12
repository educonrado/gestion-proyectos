package ec.edu.usirael.gestion.proyectos.controlador;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ec.edu.usirael.gestion.proyectos.entidades.modelo.AsignacionTareas;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.HistorialAccionesTarea;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Tarea;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Usuario;
import ec.edu.usirael.gestion.proyectos.servicio.impl.AsignacionTareasServicioImpl;
import ec.edu.usirael.gestion.proyectos.servicio.impl.HistorialAccionesTareaServicioImpl;
import ec.edu.usirael.gestion.proyectos.servicio.impl.TareaServicioImpl;
import ec.edu.usirael.gestion.proyectos.servicio.impl.UsuarioServicioImpl;

@Controller
public class AsignacionTareaControlador {

	@Autowired
	private UsuarioServicioImpl usuarioServicio;
	@Autowired
	private AsignacionTareasServicioImpl asignacionServicio;
	@Autowired
	private TareaServicioImpl tareaServicio;
	@Autowired
	private HistorialAccionesTareaServicioImpl historialServicio;
	private List<Tarea> tareas;
	private List<Usuario> usuarios;
	private List<HistorialAccionesTarea> historial;

	@GetMapping("/gestion/asignacion")
	public String abrirAsignaciones(Model model) {
		
		tareas = tareaServicio.listaTareas();
		usuarios = usuarioServicio.listaUsuarios();
		historial = historialServicio.listarHistorialAccionesTarea();
		List<AsignacionTareas> asignacion = asignacionServicio.listaAsignacionTareas();
		System.out.println("Número de asignacion: " + asignacion.size());
		model.addAttribute("asignacion", asignacion);
		model.addAttribute("tareas", tareas);
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("historial", historial);
		return "gestion/asignacionTareas";
	}

	@GetMapping("/gestion/asignacion/formulario")
	public String mostrarFormularioAsignacion(Model model) {
		usuarios = usuarioServicio.listaUsuarios();
		tareas = tareaServicio.listaTareas();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("tareas", tareas);
		model.addAttribute("nuevaAsignacion", new AsignacionTareas());
		return "gestion/asignacionFormulario";
	}

	@GetMapping("/gestion/asignacion/editar/{id}")
	public String mostrarFormularioEdicionAsignacion(@PathVariable("id") int id, Model model) {
		usuarios = usuarioServicio.listaUsuarios();
		tareas = tareaServicio.listaTareas();
		Optional<AsignacionTareas> asignacion = asignacionServicio.obtenerAsignacionPorCodigo(id);
		model.addAttribute("nuevaAsignacion", asignacion.get());
		model.addAttribute("codigo", asignacion.get().getCodigo());
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("tareas", tareas);
		return "gestion/asignacionFormulario";

	}

	@PostMapping("/gestion/asignacion/guardar")
	public String crearAsignacion(@ModelAttribute("nuevaAsignacion") AsignacionTareas asignacion) {
		asignacionServicio.crear(asignacion);
		HistorialAccionesTarea historial = new HistorialAccionesTarea();
		historial.setFechaActualizacion(LocalDate.now());
		historial.setAsignacion(asignacion);
		historial.setDetalles("Actualización");
		historialServicio.crear(historial);
		return "redirect:/gestion/asignacion";
	}
	
	@GetMapping("/gestion/asignacion/eliminar/{id}")
	public String eliminarAsignacion(@PathVariable("id") int id) {
		asignacionServicio.eliminar(id);
		return "redirect:/gestion/asignacion"; 
	}
}
