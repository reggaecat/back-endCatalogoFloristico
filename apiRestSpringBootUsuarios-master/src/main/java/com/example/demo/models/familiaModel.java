package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "familia")
public class familiaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id_familia;
    private String nombre;

    /*
     * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =
     * "familiaModel")
     * 
     * @JsonIgnore
     * private Set<plantasModel> investigacionInvestigador = new HashSet<>();
     */

    public int getId() {
        return id_familia;
    }

    public void setId(int id) {
        this.id_familia = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}