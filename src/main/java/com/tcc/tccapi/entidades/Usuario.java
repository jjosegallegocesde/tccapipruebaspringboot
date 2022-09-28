package com.tcc.tccapi.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usuario")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="telefono")
    private String telefono;

    @Column(name="estado")
    private boolean estado;

    @Column(name="id_sede")
    private int id_sede;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_sede",referencedColumnName = "id",insertable=false, updatable=false)
    private Sede sede;



    public Usuario() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId_sede() {
        return id_sede;
    }


}
