package com.example.disney.datos;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
public class PeliculaPersonaje {
	@EmbeddedId
    private PeliculaPersonajeId id;

    @ManyToOne
    @MapsId("peliculaId")
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    @ManyToOne
    @MapsId("personajeId")
    @JoinColumn(name = "personaje_id")
    private Personaje personaje;
    
    public PeliculaPersonaje(Pelicula pelicula, Personaje personaje) {
        this.id = new PeliculaPersonajeId(pelicula.getId(), personaje.getId());
        this.pelicula = pelicula;
        this.personaje = personaje;
    }
}
