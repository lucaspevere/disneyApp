package com.example.disney.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.disney.datos.Personaje;
import com.example.disney.dto.PersonajeDto;
import com.example.disney.servicios.PersonajeServicio;




@RestController
@RequestMapping(value = "/characters")
public class PersonajeControlador {
	
	@Autowired
	PersonajeServicio servicio;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<PersonajeDto> getPersonajes() {
		return servicio.getPersonajes();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Personaje guardarPersonaje(@RequestBody Personaje personaje) {
		servicio.guardarPersonaje(personaje);
		return personaje;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Personaje actualizarPersonaje(@RequestBody Personaje personaje) {
		servicio.actualizarPersonaje(personaje);
		return personaje;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void eliminarPersonaje(@PathVariable(name = "id") Long idPersonaje) {
		servicio.eliminarPersonaje(idPersonaje);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"name"})
	public Iterable<PersonajeDto> getPersonajePorNombre(
			@RequestParam(name = "name") String nombrePersonaje) {
		return servicio.getPersonajesPorNombre(nombrePersonaje);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"age"})
	public Iterable<PersonajeDto> getPersonajePorEdad(
			@RequestParam(name = "age") Integer edad) {
		return servicio.getPersonajesPorEdad(edad);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"movies"})
	public Iterable<PersonajeDto> getPersonajesPorPelicula(
			@RequestParam(name = "movies") Long idMovie) {
		return servicio.getPersonajesPorPelicula(idMovie);
	}
	
	
	

}
