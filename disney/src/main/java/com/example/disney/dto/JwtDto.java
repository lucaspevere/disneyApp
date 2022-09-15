package com.example.disney.dto;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class JwtDto {
	@NonNull
	private String token;

	@NonNull
	private String bearer = "Bearer";

	@NonNull
	private String nombreUsuario;
}
