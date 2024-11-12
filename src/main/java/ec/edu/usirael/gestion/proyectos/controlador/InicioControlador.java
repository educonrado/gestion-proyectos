package ec.edu.usirael.gestion.proyectos.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControlador {

    @GetMapping("/")
    public String obtenerDashboard() {
        return "index";
    }
}
