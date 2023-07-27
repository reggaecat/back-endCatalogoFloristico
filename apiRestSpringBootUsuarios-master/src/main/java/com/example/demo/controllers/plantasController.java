package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.plantasModel;
import com.example.demo.services.plantasService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/plantas")
public class plantasController {

    @Autowired
    plantasService usuarioService;

    @GetMapping()
    public ArrayList<plantasModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public plantasModel guardarUsuario(@RequestParam("user") String datosJson,
            @RequestParam("imagen") MultipartFile imagen) throws JsonMappingException, JsonProcessingException {
        plantasModel usuario2 = new ObjectMapper().readValue(datosJson, plantasModel.class);
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("extrae el modelo" + usuario2.getNombre());
        if (!imagen.isEmpty()) {
            System.out.println("entra al if");
            try {
                System.out.println("entra al try");
                usuario2.setFoto(imagen.getBytes());

            } catch (Exception e) {
                System.out.println("Error al ingresar la imagen");
            }
        }
        return this.usuarioService.guardarUsuario(usuario2);
    }

    @GetMapping(path = "/{id}")
    public Optional<plantasModel> obtenerUsuarioPorId(@PathVariable("id") int id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<plantasModel> obtenerUsuarioPorPrioridad(@RequestParam("nombre") String prioridad) {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @GetMapping("/{id}/imagen")
    public ResponseEntity<byte[]> obtenerImagen(@PathVariable int id) {
        plantasModel plantas = usuarioService.obtenerPorId(id).get();
        if (plantas != null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(plantas.getFoto());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") int id) {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
