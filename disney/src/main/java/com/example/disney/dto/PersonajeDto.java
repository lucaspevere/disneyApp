package com.example.disney.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class PersonajeDto {
	private byte[] imagePersonaje;
	
	private String nombre;

}
