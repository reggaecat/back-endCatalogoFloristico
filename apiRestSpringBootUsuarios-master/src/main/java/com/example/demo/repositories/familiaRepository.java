package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.familiaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface familiaRepository extends CrudRepository<familiaModel, Integer> {
    public abstract ArrayList<familiaModel> findByNombre(String nombre);

}