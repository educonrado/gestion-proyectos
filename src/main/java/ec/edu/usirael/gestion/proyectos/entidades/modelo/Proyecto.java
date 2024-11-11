package ec.edu.usirael.gestion.proyectos.entidades.modelo;

import ec.edu.usirael.gestion.proyectos.entidades.enumerador.EstadoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nombre;

    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    private double presupuesto;

    @OneToMany(mappedBy = "proyecto")
    private List<Tarea> tareas;

}
