package com.grupo2.lucasteam.model;

import java.time.Year;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Clase Plataforma que representa la entidad plataforma reflejada en la base de
 * datos.
 * 
 * @author Álvaro Román Gómez
 * @version 1.0: 22/09/2022
 * 
 */

@Entity
@Table(name = "juegos")
@Data
public class Juego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int rango;
	private String nombre;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Plataforma id_plataforma;
	private Year fecha;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Genero id_genero;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Editor id_editor;
	private double NA_ventas;
	private double EU_ventas;
	private double JP_ventas;
	private double otras_ventas;
	private double ventas_globales;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Juego))
			return false;
		Juego other = (Juego) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(id_editor, other.id_editor)
				&& Objects.equals(id_genero, other.id_genero) && Objects.equals(id_plataforma, other.id_plataforma)
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(EU_ventas, JP_ventas, NA_ventas, fecha, id, id_editor, id_genero, id_plataforma, nombre,
				otras_ventas, rango, ventas_globales);
	}

}