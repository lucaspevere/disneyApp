package com.example.disney.datos;



import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import javax.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Genero {
	@Id
	@SequenceGenerator(name = "seq_genero", sequenceName = "seq_genero")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_genero")
	private Long id;
	
	private String nombre;
	
	@Lob
	@Column(name="BLOB_COLUMN_GENERO")
	@Type(type = "org.hibernate.type.ImageType")
	private byte[] imageGenero;
	
}
