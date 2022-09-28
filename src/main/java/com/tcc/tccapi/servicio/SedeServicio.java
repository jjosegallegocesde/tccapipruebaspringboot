package com.tcc.tccapi.servicio;

import com.tcc.tccapi.entidades.Sede;


import java.util.Optional;

public interface SedeServicio {

    public Iterable<Sede> buscarSedes();

    public Optional<Sede> buscarSedePorId(Integer id);

    public Sede guardar(Sede sede);

    public void eliminarSedePorId(Integer id);
}
