package com.example.disney.datos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.JoinColumn;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Pelicula")
public class Pelicula {
	@Id
	@SequenceGenerator(name = "seq_pelicula", sequenceName = "seq_pelicula")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pelicula")
	private Long id;
	
	@Lob
	@Column(name="BLOB_COLUMN_PELICULA")
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] imagePelicula;
	
	private String titulo;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Argentina/Cordoba")
	private Date fechaCreacion;
	
	@Max(5)
	@Min(1)
	private Integer calificacion;
	
	/*@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "pelicula_personaje",
            joinColumns = @JoinColumn(name = "idPelicula"),
            inverseJoinColumns = @JoinColumn(name = "idPersonaje")
    )
    private Set<Personaje> personajes;*/
	
	@OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PeliculaPersonaje> peliculaPersonaje = new HashSet<>();
	
	
	@ManyToOne
	private Genero genero;
	
}
