package com.example.disney.servicios;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.disney.dto.PeliculaDto;
import com.example.disney.dto.PersonajeDto;
import com.example.disney.datos.Pelicula;
import com.example.disney.datos.PeliculaPersonaje;
import com.example.disney.datos.Personaje;
import com.example.disney.repositorios.GeneroRepositorio;
import com.example.disney.repositorios.PeliculaPersonajeRepositorio;
import com.example.disney.repositorios.PeliculaRepositorio;
import com.example.disney.repositorios.PersonajeRepositorio;




@Service
public class PeliculaServicio {
	@Autowired
	PeliculaRepositorio repositorio;
	
	@Autowired
	GeneroRepositorio repositorioGenero;
	
	@Autowired
	PersonajeRepositorio repositorioPersonaje;
	
	@Autowired
	PeliculaPersonajeRepositorio repositorioPeliculaPersonaje;

	public Pelicula guardarPelicula(Pelicula pelicula) {
		return repositorio.save(pelicula);
	}

	public Pelicula actualizarPelicula(Pelicula pelicula) {
		return repositorio.save(pelicula);
	}

	public void eliminarPelicula(Long idPelicula) {
		 repositorio.deleteById(idPelicula);
	}

	public Iterable<PeliculaDto> getPeliculas() {
		Iterable<Pelicula> peliculas = repositorio.findAll();
		return getPeliculaDto(peliculas);
	}
	private Iterable<PeliculaDto> getPeliculaDto(Iterable<Pelicula> peliculas){
		ArrayList<PeliculaDto> peliculasDto = new ArrayList<>();
		for (Pelicula p : peliculas) {
			PeliculaDto peliculaDto = new PeliculaDto();
			peliculaDto.setImagePelicula(p.getImagePelicula());
			peliculaDto.setTitulo(p.getTitulo());
			peliculaDto.setFechaCreacion(p.getFechaCreacion());
			peliculasDto.add(peliculaDto);
		}
		return peliculasDto;
	}

	public Iterable<PeliculaDto> getPeliculasPorNombre(String nombrePelicula) {
		Iterable<Pelicula> pelicula = repositorio.findAllByTituloIgnoreCaseStartingWith(nombrePelicula);
		return getPeliculaDto(pelicula);
	}

	public Iterable<PeliculaDto> getPeliculasPorGenero(Long idGenero) {
		Iterable<Pelicula> peliculas = repositorio.findByGeneroId(idGenero);
		return getPeliculaDto(peliculas);
	}
	

	public Iterable<PeliculaDto> getPeliculasPorOrden(String ascDesc) {
		if (ascDesc.equals("ASC")) {
			Iterable<Pelicula> peliculas = repositorio.findAllByOrderByTituloAsc();
			return getPeliculaDto(peliculas);
		} 
		if (ascDesc.equals("DESC")) {
			Iterable<Pelicula> peliculas = repositorio.findAllByOrderByTituloDesc();
			return getPeliculaDto(peliculas);
		}
		return null;
	}

	@Transactional
	public String agregarPesonajePelicula(Long idMovie, Long idCharacter) {
		Optional<Pelicula> pelicula = repositorio.findById(idMovie);
		Optional<Personaje> personaje = repositorioPersonaje.findById(idCharacter);
		if (pelicula!=null && personaje!=null) {
			PeliculaPersonaje peliPerso = new PeliculaPersonaje(pelicula.get(),personaje.get());
			repositorioPeliculaPersonaje.save(peliPerso);
			return "Personaje agregado";
		}
		return null;
		
	}

	@Transactional
	public String removerPesonajePelicula(Long idMovie, Long idCharacter) {
		Optional<Pelicula> pelicula = repositorio.findById(idMovie);
		Optional<Personaje> personaje = repositorioPersonaje.findById(idCharacter);
		if (pelicula!=null && personaje!=null) {
			repositorioPeliculaPersonaje.deleteByPeliculaAndPersonaje(pelicula,personaje);
			return "Personaje eliminado";
		}
		return null;
	}
}
