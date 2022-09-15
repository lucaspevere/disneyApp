package com.example.disney.dto;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class PeliculaDto {
	private byte[] imagePelicula;
	
	private String titulo;
	
	private Date fechaCreacion;
	

}
