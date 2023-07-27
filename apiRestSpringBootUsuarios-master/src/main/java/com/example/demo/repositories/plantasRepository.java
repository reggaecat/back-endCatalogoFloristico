package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.plantasModel;

@Repository
public interface plantasRepository extends CrudRepository<plantasModel, Integer> {
    public abstract ArrayList<plantasModel> findByNombre(String nombre);

}
