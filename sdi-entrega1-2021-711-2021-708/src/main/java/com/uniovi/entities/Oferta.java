package com.uniovi.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "oferta")
public class Oferta {
	
	@Id
	@GeneratedValue
	public Long id;
	public String titulo;
	public String descripcion;
	public Date fecha = new Date();
	public int precio;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	public Oferta(String titulo, String descripcion, int precio) {
		super();
		this.titulo=titulo;
		this.descripcion=descripcion;
		this.precio=precio;
	}
	
	public Oferta(User user, String titulo, String descripcion, int precio) {
		this(titulo,descripcion,precio);
		this.user=user;
	}
	
	public Oferta() {
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
