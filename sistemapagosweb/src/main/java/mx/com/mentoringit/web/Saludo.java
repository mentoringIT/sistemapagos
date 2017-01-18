package mx.com.mentoringit.web;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Saludo {

	public String nombre;

	public Saludo() {

	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}