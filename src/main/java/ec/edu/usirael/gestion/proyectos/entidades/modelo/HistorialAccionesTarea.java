package ec.edu.usirael.gestion.proyectos.entidades.modelo;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class HistorialAccionesTarea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String detalles;

    private LocalDate fechaActualizacion;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estadoAnterior;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estadoActual;

    @JoinColumn(name = "codigo_asignacion_tarea")
    @ManyToOne
    private AsignacionTareas asignacion;
}
