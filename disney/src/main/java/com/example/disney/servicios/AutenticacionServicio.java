package com.example.disney.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.disney.dto.LoginDto;
import com.google.auth.oauth2.JwtProvider;



@Service
public class AutenticacionServicio {
	@Autowired
	private EmailServicio emailServicio;
	
	/*@Autowired
	AuthenticationManager authenticationManager;*/
	
	/*@Autowired
	JwtProvider jwtProvider;*/

	public ResponseEntity<?> registrarUsuario(LoginDto loginUsuario) {
		String nombreUsuario = loginUsuario.getNombre();
		String passUsuario = loginUsuario.getPass();
		
		// 
		//BCryptPasswordEncoder encrip = new BCryptPasswordEncoder();//
		// Usuario usuario = new Usuario();//       
		// usuario.setNombre(nombreUsuario)//
		// usuario.setPass(encrip.encode(passUsuario));//
		//repositorioUsuario.save(usuario);//
		//
		
		String subject="¡Bienvenido!";
		String body="¡Muchas gracias por elegir <i>DisneyApp</i> \n\n";
		emailServicio.sendEmail(loginUsuario.getEmail(), subject, body);
		return new ResponseEntity<Object>(new String("Usuario registrado correctamente!"),
				HttpStatus.OK);
	}

	public ResponseEntity<?> loginUsuario(LoginDto loginUsuario) {
		//Authentication authentication = authenticationManager.authenticate(
		//		new UsernamePasswordAuthenticationToken(loginUsuario.getNombre(), loginUsuario.getPass()));
		//SecurityContextHolder.getContext().setAuthentication(authentication);
		//String jwt = jwtProvider.generarToken(authentication);
		//UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		//JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(),
			//	new String("Usuario autenticado correctamente."), "");
		//logger.info("Usuario: " + loginUsuario.getNombre() + " autenticado correctamente.");
		
		return null;
	}

}
