package com.example.disney.repositorios;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.disney.datos.Pelicula;
import com.example.disney.datos.PeliculaPersonaje;
import com.example.disney.datos.PeliculaPersonajeId;
import com.example.disney.datos.Personaje;

public interface PeliculaPersonajeRepositorio extends JpaRepository <PeliculaPersonaje, PeliculaPersonajeId>{

	void deleteByPeliculaAndPersonaje(Optional<Pelicula> pelicula, Optional<Personaje> personaje);

}
