package ec.edu.usirael.gestion.proyectos.entidades.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nombre;
    private String correo;
    private boolean estado;

    @OneToMany(mappedBy = "usuario")
    private List<AsignacionTareas> tareasAsignadas;
}
