package ec.edu.usirael.gestion.proyectos.controlador;

import ec.edu.usirael.gestion.proyectos.servicio.impl.ProyectoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProyectoControlador {

    @Autowired
    private ProyectoServicioImpl proyectoServicio;

    @GetMapping("/gestion/proyectos")
    public String abrirProyectos(Model model) {
        model.addAttribute("proyectos", proyectoServicio.listaProyectos());
        return "gestion/proyectos";
    }
}
