package ec.edu.usirael.gestion.proyectos.entidades.repositorio;

import ec.edu.usirael.gestion.proyectos.entidades.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    public List<Usuario> findByEstado(boolean estado);
    public List<Usuario> findByCorreo(String correo);
    public List<Usuario> findByNombre(String nombre);
    public List<Usuario> findByNombreAndEstado(String nombre, boolean estado);
    public List<Usuario> findByCorreoAndEstado(String correo, boolean estado);

}
