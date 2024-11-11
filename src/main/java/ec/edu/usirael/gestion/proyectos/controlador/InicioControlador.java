package ec.edu.usirael.gestion.proyectos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControlador {

    @GetMapping("/")
    public String obtenerDashboard() {
        return "index";
    }
    @GetMapping("/gestion/proyectos")
    public String abrirProyectos() {
        return "gestion/proyectos";
    }
    @GetMapping("/gestion/tareas")
    public String abrirTareas() {
        return "gestion/tareas";
    }
    @GetMapping("/gestion/usuarios")
    public String abrirUsuarios() {
        return "gestion/usuarios";
    }
}
