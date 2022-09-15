package com.example.disney.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.disney.datos.Genero;
import com.example.disney.servicios.GeneroServicio;



@RestController
@RequestMapping(value = "/gender")
public class GeneroControlador {
	@Autowired
	GeneroServicio servicio;
	
	@RequestMapping(method = RequestMethod.POST)
	public Genero guardarGenero(@RequestBody Genero genero) {
		return servicio.guardarGenero(genero);
	}

}
