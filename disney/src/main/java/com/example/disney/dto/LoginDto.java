package com.example.disney.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginDto {
	
	private String nombre;

	private String pass;
	
	private String email;

}
