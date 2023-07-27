package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "plantas")
public class plantasModel {
    private int id_floristica;
    private String nombre_familia;
    private String nombre_orden;
    private String nombre;
    private String nombre_cientifica;
    private String nombre_quichua;
    private String descripcion;
    @Lob
    @Column(name = "foto", columnDefinition = "BLOB")
    private byte[] foto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public int getId_floristica() {
        return id_floristica;
    }

    public void setId_floristica(int id_floristica) {
        this.id_floristica = id_floristica;
    }

    public String getNombre_familia() {
        return nombre_familia;
    }

    public void setNombre_familia(String nombre_familia) {
        this.nombre_familia = nombre_familia;
    }

    

    public String getNombre_orden() {
        return nombre_orden;
    }

    public void setNombre_orden(String nombre_orden) {
        this.nombre_orden = nombre_orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_cientifica() {
        return nombre_cientifica;
    }

    public void setNombre_cientifica(String nombre_cientifica) {
        this.nombre_cientifica = nombre_cientifica;
    }

    public String getNombre_quichua() {
        return nombre_quichua;
    }

    public void setNombre_quichua(String nombre_quichua) {
        this.nombre_quichua = nombre_quichua;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}
