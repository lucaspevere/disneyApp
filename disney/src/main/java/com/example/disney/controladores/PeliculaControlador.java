package com.example.disney.controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.disney.datos.Pelicula;
import com.example.disney.datos.Personaje;
import com.example.disney.dto.PeliculaDto;
import com.example.disney.dto.PersonajeDto;
import com.example.disney.servicios.PeliculaServicio;

@RestController
@RequestMapping(value = "/movies")
public class PeliculaControlador {
	
	@Autowired
	PeliculaServicio servicio;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<PeliculaDto> getPeliculas() {
		return servicio.getPeliculas();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Pelicula guardarPelicula(@RequestBody Pelicula pelicula) {
		servicio.guardarPelicula(pelicula);
		return pelicula;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Pelicula actualizarPelicula(@RequestBody Pelicula pelicula) {
		servicio.actualizarPelicula(pelicula);
		return pelicula;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void eliminarPelicula(@PathVariable(name = "id") Long idPelicula) {
		servicio.eliminarPelicula(idPelicula);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"name"})
	public Iterable<PeliculaDto> getPeliculasPorNombre(
			@RequestParam(name = "name") String nombrePelicula) {
		return servicio.getPeliculasPorNombre(nombrePelicula);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"genre"})
	public Iterable<PeliculaDto> getPeliculasPorGenero(
			@RequestParam(name = "genre") Long idGenero) {
		return servicio.getPeliculasPorGenero(idGenero);
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"order"})
	public Iterable<PeliculaDto> getPeliculasPorOrden(
			@RequestParam(name = "order") String AscDesc) {
		return servicio.getPeliculasPorOrden(AscDesc);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{idMovie}/characters/{idCharacter}")
	public String agregarPersonajePelicula(
			@PathVariable(name = "idMovie") Long idMovie,
			@PathVariable(name = "idCharacter") Long idCharacter) {
		return servicio.agregarPesonajePelicula(idMovie, idCharacter);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idMovie}/characters/{idCharacter}")
	public String removerPersonajePelicula(
			@PathVariable(name = "idMovie") Long idMovie,
			@PathVariable(name = "idCharacter") Long idCharacter) {
		return servicio.removerPesonajePelicula(idMovie, idCharacter);
	}
	
}
