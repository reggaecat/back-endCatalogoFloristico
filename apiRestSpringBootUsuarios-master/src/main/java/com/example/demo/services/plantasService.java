package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.plantasModel;
import com.example.demo.repositories.plantasRepository;

@Service
public class plantasService {

    @Autowired
    plantasRepository usuarioRepository;

    public ArrayList<plantasModel> obtenerUsuarios() {
        return (ArrayList<plantasModel>) usuarioRepository.findAll();
    }

    public plantasModel guardarUsuario(plantasModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<plantasModel> obtenerPorId(int id) {
        return usuarioRepository.findById(id);
    }

    public ArrayList<plantasModel> obtenerPorPrioridad(String prioridad) {
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
