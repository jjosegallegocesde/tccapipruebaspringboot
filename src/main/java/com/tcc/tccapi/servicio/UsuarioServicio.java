package com.tcc.tccapi.servicio;

import com.tcc.tccapi.entidades.Usuario;
import java.util.Optional;

public interface UsuarioServicio {

    public Iterable<Usuario> buscarUsuarios();

    public Optional<Usuario> buscarUsuarioPorId(Integer id);

    public Usuario guardarUsuario(Usuario usuario);

    public void eliminarUsuarioPorId(Integer id);

}
