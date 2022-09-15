package com.example.disney.datos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Embeddable
public class PeliculaPersonajeId implements Serializable{
	
	@Column(name = "pelicula_id")
    private Long peliculaId;

    @Column(name = "personaje_id")
    private Long personajeId;

}
