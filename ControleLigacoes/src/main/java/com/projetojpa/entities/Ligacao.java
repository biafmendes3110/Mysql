package com.projetojpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name= "ligacao")
public class Ligacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@NotBlank
	@Column(name= "data")
	private String data;

	@NotNull
	@NotBlank
	@Column(name= "horarioInicio")
	private String horarioInicio;
	
	@NotNull
	@NotBlank
	@Column(name= "horarioTermino")
	private String horarioTermino;
	
	@NotNull
	@NotBlank
	@Column(name= "telefoneDiscado")
	private String telefoneDiscado;

	public long getId() {
		return id;
	}
	public void setId (long id) {
		this.id= id;
	}

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data=data;
	}
	public String getHorarioTermino() {
		return horarioTermino;
	}
	public void setHorarioTermino(String horarioTermino) {
		this.horarioTermino=horarioTermino;
	}
	public String getTelefoneDiscado() {
		return telefoneDiscado;
	}
	public void setTelefoneDiscado(String telefoneDiscado) {
		this.telefoneDiscado=telefoneDiscado;
	}
}

