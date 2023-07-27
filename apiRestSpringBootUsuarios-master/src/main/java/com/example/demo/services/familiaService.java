package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.familiaModel;
import com.example.demo.repositories.familiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class familiaService {
    @Autowired
    familiaRepository usuarioRepository;

    public ArrayList<familiaModel> obtenerUsuarios() {
        return (ArrayList<familiaModel>) usuarioRepository.findAll();
    }

    public familiaModel guardarUsuario(familiaModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<familiaModel> obtenerPorId(int id) {
        return usuarioRepository.findById(id);
    }

    public ArrayList<familiaModel> obtenerPorPrioridad(String prioridad) {
        return usuarioRepository.findByNombre(prioridad);
    }

    public boolean eliminarUsuario(int id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}