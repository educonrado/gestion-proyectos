package ec.edu.usirael.gestion.proyectos.servicio;

import ec.edu.usirael.gestion.proyectos.entidades.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public void crear(Usuario usuario);

    public void actualizar(Usuario usuario);

    public void eliminar(int codigo);

    public List<Usuario> listaUsuarios();

    public List<Usuario> listaUsuariosActivos(boolean estado);
    public List<Usuario> findByCorreoAndEstado(String correo, boolean estado);
    public List<Usuario> findByNombreAndEstado(String nombre, boolean estado);
    public List<Usuario> findByNombre(String nombre);
    public List<Usuario> findByCorreo(String correo);

}
