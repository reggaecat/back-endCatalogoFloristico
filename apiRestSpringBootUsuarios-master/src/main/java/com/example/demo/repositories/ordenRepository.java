package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ordenModel;

@Repository
public interface ordenRepository extends CrudRepository<ordenModel, Integer> {
    public abstract ArrayList<ordenModel> findByNombre(String nombre);
}
