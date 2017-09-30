package com.app.beans;

import java.util.List;

public class Tienda {
	
	private int id;
	private String nombre;
	private List<Producto> Productos;
	
	public Tienda() {
	}
	
	public Tienda(int id, String nombre, List<Producto> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		Productos = productos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Producto> getProductos() {
		return Productos;
	}
	public void setProductos(List<Producto> productos) {
		Productos = productos;
	} 

	
	
}

