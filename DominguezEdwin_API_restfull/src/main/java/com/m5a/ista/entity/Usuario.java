package com.m5a.ista.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String nombre;
	
	@Column(length = 10, name= "contrasenia")
	private String clave;
	
	@Column(length = 50, name = "correo")
	private String email;
	
	@Column(length = 50)
	private String estado;
	
	
	public Usuario() {
		super();
		
	}
	

	public Usuario(Long id, String nombre, String clave, String email, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.email = email;
		this.estado = estado;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", clave=" + clave + ", email=" + email + ", estado="
				+ estado + "]";
	}
	
	
	
	
	
	
	
	
}
