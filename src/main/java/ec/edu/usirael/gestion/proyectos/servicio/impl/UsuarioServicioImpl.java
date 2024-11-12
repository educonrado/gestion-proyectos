package ec.edu.usirael.gestion.proyectos.servicio.impl;

import ec.edu.usirael.gestion.proyectos.entidades.modelo.Usuario;
import ec.edu.usirael.gestion.proyectos.entidades.repositorio.IUsuarioRepositorio;
import ec.edu.usirael.gestion.proyectos.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    @Override
    public void crear(Usuario usuario) {
        try {
            usuarioRepositorio.save(usuario);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        try {
            usuarioRepositorio.save(usuario);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public void eliminar(int codigo) {
        try {
            usuarioRepositorio.deleteById(codigo);
        } catch (Exception e) {
            System.err.println("Error: No se puede crear el objeto. " + e);
        }
    }

    @Override
    public List<Usuario> listaUsuarios() {
        try {
            return usuarioRepositorio.findAll();
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Usuario> listaUsuariosActivos(boolean estado) {
        try {
            return usuarioRepositorio.findByEstado(estado);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Usuario> findByCorreoAndEstado(String correo, boolean estado) {
        try {
            return usuarioRepositorio.findByCorreoAndEstado(correo, estado);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Usuario> findByNombreAndEstado(String nombre, boolean estado) {
        try {
            return usuarioRepositorio.findByNombreAndEstado(nombre, estado);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Usuario> findByNombre(String nombre) {
        try {
            return usuarioRepositorio.findByNombre(nombre);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

    @Override
    public List<Usuario> findByCorreo(String correo) {
        try {
            return usuarioRepositorio.findByCorreo(correo);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
    }

	public Optional<Usuario> obtenerUsuarioPorCodigo(int id) {
		try {
			return usuarioRepositorio.findById(id);
        } catch (Exception e) {
            System.err.println("Error: No se puede obtener lista de objeto. " + e);
            return null;
        }
	}
}
