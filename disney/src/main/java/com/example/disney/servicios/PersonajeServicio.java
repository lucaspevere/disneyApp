package com.example.disney.servicios;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.disney.datos.Pelicula;
import com.example.disney.datos.PeliculaPersonaje;
import com.example.disney.datos.Personaje;
import com.example.disney.dto.PersonajeDto;
import com.example.disney.repositorios.PeliculaRepositorio;
import com.example.disney.repositorios.PersonajeRepositorio;



@Service
public class PersonajeServicio {
	
	@Autowired
	PersonajeRepositorio repositorio;
	
	@Autowired
	PeliculaRepositorio	repositorioPelicula;

	public Personaje guardarPersonaje(Personaje personaje) {
		return repositorio.save(personaje);
	}

	public Personaje actualizarPersonaje(Personaje personaje) {
		return repositorio.save(personaje);
		
	}

	public void eliminarPersonaje(Long idPersonaje) {
		repositorio.deleteById(idPersonaje);
		
	}
	
	public Iterable<PersonajeDto> getPersonajes() {
		Iterable<Personaje> personajes = repositorio.findAll();
		return getPersonajesDto(personajes);
	}

	public Iterable<PersonajeDto> getPersonajesPorNombre(String nombrePersonaje) {
		Iterable<Personaje> personajes = repositorio.findAllByNombreIgnoreCaseStartingWith(nombrePersonaje);
		return getPersonajesDto(personajes);
	}

	public Iterable<PersonajeDto> getPersonajesPorEdad(Integer edad) {
		Iterable<Personaje> personajes = repositorio.findAllByEdad(edad);
		return getPersonajesDto(personajes);
	}

	public Iterable<PersonajeDto> getPersonajesPorPelicula(Long idMovie) {
		Optional<Pelicula> pelicula = repositorioPelicula.findById(idMovie);
		if (pelicula!=null) {
			Set<PeliculaPersonaje> personajes = pelicula.get().getPeliculaPersonaje();
			ArrayList<PersonajeDto> personajesDto = new ArrayList<>();
			for (PeliculaPersonaje p: personajes) {
				PersonajeDto personajeDto = new PersonajeDto();
				personajeDto.setNombre(p.getPersonaje().getNombre());
				personajeDto.setImagePersonaje(p.getPersonaje().getImagePersonaje());
				personajesDto.add(personajeDto);
			}
			return personajesDto;
		}
		return null;
	}
	
	private Iterable<PersonajeDto> getPersonajesDto(Iterable<Personaje> personajes){
		ArrayList<PersonajeDto> personajesDto = new ArrayList<>();
		for (Personaje p : personajes) {
			PersonajeDto personajeDto = new PersonajeDto();
			personajeDto.setNombre(p.getNombre());
			personajeDto.setImagePersonaje(p.getImagePersonaje());
			personajesDto.add(personajeDto);
		}
		return personajesDto;
	}

	
	
	
	


}
