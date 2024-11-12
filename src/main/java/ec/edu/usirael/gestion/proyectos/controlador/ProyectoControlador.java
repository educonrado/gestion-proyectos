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

import ec.edu.usirael.gestion.proyectos.entidades.modelo.Proyecto;
import ec.edu.usirael.gestion.proyectos.servicio.impl.ProyectoServicioImpl;

@Controller
public class ProyectoControlador {

	@Autowired
	private ProyectoServicioImpl proyectoServicio;

	@GetMapping("/gestion/proyectos")
	public String abrirProyectos(Model model) {
		List<Proyecto> proyectos = proyectoServicio.listaProyectos();
		System.out.println("Número de proyectos: " + proyectos.size());
		model.addAttribute("proyectos", proyectos);
		return "gestion/proyectos";
	}

	@GetMapping("/gestion/proyectos/formulario")
	public String mostrarFormulario(Model model) {
		model.addAttribute("nuevoProyecto", new Proyecto());
		return "gestion/proyectosFormulario";
	}

	@GetMapping("/gestion/proyectos/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") int id, Model model) {
		Optional<Proyecto> proyecto = proyectoServicio.obtenerProyectoPorCodigo(id);
		model.addAttribute("nuevoProyecto", proyecto.get());
		model.addAttribute("codigo", proyecto.get().getCodigo());
		return "gestion/proyectosFormulario";

	}

	@PostMapping("/gestion/proyectos/guardar")
	public String crearProyecto(@ModelAttribute("nuevoProyecto") Proyecto nuevoProyecto) {
		proyectoServicio.crear(nuevoProyecto);
		return "redirect:/gestion/proyectos";
	}
	
	@GetMapping("/gestion/proyectos/eliminar/{id}")
	public String eliminarProyecto(@PathVariable("id") int id) {
		proyectoServicio.eliminar(id);
		return "redirect:/gestion/proyectos"; 
	}
}
