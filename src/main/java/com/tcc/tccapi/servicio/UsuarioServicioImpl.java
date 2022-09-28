package com.tcc.tccapi.servicio;


import com.tcc.tccapi.entidades.Sede;
import com.tcc.tccapi.entidades.Usuario;
import com.tcc.tccapi.repositorios.SedeRepositorio;
import com.tcc.tccapi.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional(readOnly = true)
    @Override
    public Iterable<Usuario> buscarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Usuario> buscarUsuarioPorId(Integer id) {
        return usuarioRepositorio.findById(id);
    }

    @Transactional
    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Transactional
    @Override
    public void eliminarUsuarioPorId(Integer id) {
        usuarioRepositorio.deleteById(id);
    }
}
