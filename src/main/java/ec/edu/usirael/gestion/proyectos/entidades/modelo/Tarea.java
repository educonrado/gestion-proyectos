package ec.edu.usirael.gestion.proyectos.entidades.modelo;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import ec.edu.usirael.gestion.proyectos.entidades.enumerador.PrioridadEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
    private EstadoEnum estado = EstadoEnum.PENDIENTE;

    @Enumerated(EnumType.STRING)
    private PrioridadEnum prioridad;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "codigo_proyecto")
    private Proyecto proyecto;

    @OneToMany(mappedBy = "tarea")
    private List<AsignacionTareas> tareasAsignadas;
    
    @Override
    public String toString() {
        return "Tarea{id=" + codigo + ", nombre='" + nombre + "'}";
    }
}
