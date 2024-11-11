package ec.edu.usirael.gestion.proyectos.entidades.modelo;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import ec.edu.usirael.gestion.proyectos.entidades.enumerador.PrioridadEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nombre;

    private String descripcion;

    private int progreso;
    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    @Enumerated(EnumType.STRING)
    private PrioridadEnum prioridad;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "codigo_proyecto")
    private Proyecto proyecto;

    @OneToMany(mappedBy = "tarea")
    private List<AsignacionTareas> tareasAsignadas;
}
