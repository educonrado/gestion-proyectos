package ec.edu.usirael.gestion.proyectos.entidades.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class AsignacionTareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

	@Override
	public String toString() {
		return "AsignacionTareas [codigo=" + codigo + ", fechaAsignacion=" + fechaAsignacion + "]";
	}

}
