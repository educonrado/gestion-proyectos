package ec.edu.usirael.gestion.proyectos.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import ec.edu.usirael.gestion.proyectos.entidades.enumerador.PrioridadEnum;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Proyecto;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Tarea;
import ec.edu.usirael.gestion.proyectos.entidades.modelo.Usuario;
import ec.edu.usirael.gestion.proyectos.servicio.impl.ProyectoServicioImpl;
import ec.edu.usirael.gestion.proyectos.servicio.impl.TareaServicioImpl;
import ec.edu.usirael.gestion.proyectos.servicio.impl.UsuarioServicioImpl;

@Controller
public class TareaControlador {

	@Autowired
	private UsuarioServicioImpl usuarioServicio;
	
	@Autowired
	private TareaServicioImpl tareaServicio;
	
	@Autowired 
	private ProyectoServicioImpl proyectoServicio;
	private List<Tarea> tareas;
	private List<Usuario> usuarios;
	private List<Proyecto> proyectos;	

	@GetMapping("/gestion/tareas")
	public String abrirUsuarios(Model model) {
		tareas = tareaServicio.listaTareas();
		usuarios = usuarioServicio.listaUsuarios();
		proyectos = proyectoServicio.listaProyectos();
		System.out.println("--->Número de tareas: " + tareas.size());
		System.out.println("Número de usuarios: " + usuarios.size());
		System.out.println("Número de proyectos: " + proyectos.size());
		model.addAttribute("tareas", tareas);
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("proyectos", proyectos);
		return "gestion/tareas";
	}

	@GetMapping("/gestion/tareas/formulario")
	public String mostrarFormularioTareas(Model model) {
		usuarios = usuarioServicio.listaUsuarios();
		proyectos = proyectoServicio.listaProyectos();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("proyectos", proyectos);
		model.addAttribute("prioridad", PrioridadEnum.values());
		model.addAttribute("estado", EstadoEnum.values());
		model.addAttribute("nuevaTarea", new Tarea());
		return "gestion/tareasFormulario";
	}

	@GetMapping("/gestion/tareas/editar/{id}")
	public String mostrarFormularioEdicionTarea(@PathVariable("id") int id, Model model) {
		Optional<Tarea> tareaOpt = tareaServicio.obtenerTareaPorCodigo(id);
	    if (tareaOpt.isPresent()) {
	        Tarea tarea = tareaOpt.get();
	        model.addAttribute("nuevaTarea", tarea);
	        model.addAttribute("codigo", tarea.getCodigo());
	        model.addAttribute("proyectos", proyectoServicio.listaProyectos()); 
	        model.addAttribute("prioridad", PrioridadEnum.values());
	        model.addAttribute("estado", EstadoEnum.values());
	    } else {
	        return "redirect:/gestion/tareas";
	    }
	    return "gestion/tareasFormulario";

	}

	@PostMapping("/gestion/tareas/guardar")
	public String crearTarea(@ModelAttribute("nuevaTarea") Tarea nuevaTarea) {
		tareaServicio.crear(nuevaTarea);
		return "redirect:/gestion/tareas";
	}
	
	@GetMapping("/gestion/tareas/eliminar/{id}")
	public String eliminarTarea(@PathVariable("id") int id) {
		tareaServicio.eliminar(id);
		return "redirect:/gestion/tareas"; 
	}
}
