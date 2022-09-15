package com.example.disney.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.disney.datos.Genero;
import com.example.disney.datos.Pelicula;
import com.example.disney.datos.Personaje;

public interface PeliculaRepositorio extends CrudRepository<Pelicula, Long>{
	public Iterable<Pelicula> findAllByOrderByTituloAsc();
	public Iterable<Pelicula> findAllByOrderByTituloDesc();

	Iterable<Pelicula> findByGeneroId(Long idGenero);

	Iterable<Pelicula> findAllByTituloIgnoreCaseStartingWith(String nombrePelicula);
	//public void deleteByIdAndPersonajes(Long idMovie, Optional<Personaje> personaje);

}
