package com.example.disney.datos;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Personaje {
	@Id
	@SequenceGenerator(name = "seq_personaje", sequenceName = "seq_personaje")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_personaje")
	private Long id;
	
	@Lob
	@Column(name="BLOB_COLUMN_PERSONAJE")
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] imagePersonaje;
	
	private String nombre;
	
	private Integer edad;
	
	private Double peso;
	
	private String historia;
	
	/*@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "personajes")
    private Set<Pelicula> pelicula;*/
	
	@OneToMany(mappedBy = "personaje")
    private Set<PeliculaPersonaje> peliculaPersonaje = new HashSet<>();
}
