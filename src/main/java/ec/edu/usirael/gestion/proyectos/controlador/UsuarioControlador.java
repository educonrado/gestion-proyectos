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

import ec.edu.usirael.gestion.proyectos.entidades.modelo.Usuario;
import ec.edu.usirael.gestion.proyectos.servicio.impl.UsuarioServicioImpl;

@Controller
public class UsuarioControlador {

	@Autowired
	private UsuarioServicioImpl usuarioServicio;

	@GetMapping("/gestion/usuarios")
	public String abrirUsuarios(Model model) {
		List<Usuario> usuarios = usuarioServicio.listaUsuarios();
		System.out.println("Número de usuarios: " + usuarios.size());
		model.addAttribute("usuarios", usuarios);
		return "gestion/usuarios";
	}

	@GetMapping("/gestion/usuarios/formulario")
	public String mostrarFormularioUsuario(Model model) {
		model.addAttribute("nuevoUsuario", new Usuario());
		return "gestion/usuariosFormulario";
	}

	@GetMapping("/gestion/usuarios/editar/{id}")
	public String mostrarFormularioEdicionUsuario(@PathVariable("id") int id, Model model) {
		Optional<Usuario> usuario = usuarioServicio.obtenerUsuarioPorCodigo(id);
		model.addAttribute("nuevoUsuario", usuario.get());
		model.addAttribute("codigo", usuario.get().getCodigo());
		return "gestion/usuariosFormulario";

	}

	@PostMapping("/gestion/usuarios/guardar")
	public String crearUsuario(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario) {
		usuarioServicio.crear(nuevoUsuario);
		return "redirect:/gestion/usuarios";
	}
	
	@GetMapping("/gestion/usuarios/eliminar/{id}")
	public String eliminarUsuario(@PathVariable("id") int id) {
		usuarioServicio.eliminar(id);
		return "redirect:/gestion/usuarios"; 
	}
}
