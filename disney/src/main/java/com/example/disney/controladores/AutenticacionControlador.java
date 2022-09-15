package com.example.disney.controladores;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.disney.dto.LoginDto;
import com.example.disney.servicios.AutenticacionServicio;




@RestController
@RequestMapping(value = "/auth")
public class AutenticacionControlador {
	
	@Autowired
	AutenticacionServicio servicioAutenticacion;
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity<?> LoginUsuario(@RequestBody LoginDto loginUsuario) {	
		return servicioAutenticacion.loginUsuario(loginUsuario);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public ResponseEntity<?> RegistrarUsuario(@RequestBody LoginDto loginUsuario) {
		return servicioAutenticacion.registrarUsuario(loginUsuario);
	}
}
