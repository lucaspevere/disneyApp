package com.example.disney.repositorios;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.disney.datos.Personaje;


@Repository
public interface PersonajeRepositorio extends CrudRepository<Personaje, Long> {

	ArrayList<Personaje> findAllByNombreIgnoreCaseStartingWith(String nombrePersonaje);

	ArrayList<Personaje> findAllByEdad(Integer edad);


}
