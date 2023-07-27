package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.ordenModel;
import com.example.demo.repositories.ordenRepository;

@Service
public class ordenService {

    @Autowired
    ordenRepository usuarioRepository;

    public ArrayList<ordenModel> obtenerUsuarios() {
        return (ArrayList<ordenModel>) usuarioRepository.findAll();
    }

    public ordenModel guardarUsuario(ordenModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<ordenModel> obtenerPorId(int id) {
        return usuarioRepository.findById(id);
    }

    public ArrayList<ordenModel> obtenerPorPrioridad(String prioridad) {
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
