package com.example.disney.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.disney.datos.Genero;
import com.example.disney.repositorios.GeneroRepositorio;

@Service
public class GeneroServicio {
	@Autowired
	GeneroRepositorio repositorio;

	
	public Genero guardarGenero(Genero genero) {
		return repositorio.save(genero);
	}

}
