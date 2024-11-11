package ec.edu.usirael.gestion.proyectos.entidades.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class AsignacionTareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(name = "fecha_asignacion")
    private LocalDate fechaAsignacion;

    @JoinColumn(name = "codigo_tarea")
    @ManyToOne
    private Tarea tarea;

    @JoinColumn(name = "codigo_usuario")
    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "asignacion")
    private List<HistorialAccionesTarea> historial;

}
