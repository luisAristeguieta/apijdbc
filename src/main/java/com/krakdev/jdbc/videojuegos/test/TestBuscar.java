package com.krakdev.jdbc.videojuegos.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.jdbc.videojuegos.VideojuegoJdbc;
import com.krakdev.videojuegos.entidades.Videojuego;

public class TestBuscar {

	private static final Logger log = LogManager.getLogger(TestBuscar.class);

	public static void main(String[] args) {

		String codigo = "VG001";
		String codigo2 = "VG999";
		Videojuego videojuego = VideojuegoJdbc.buscar(codigo);
		Videojuego videojuego2 = VideojuegoJdbc.buscar(codigo2);

		if (videojuego != null) {
			log.info("Videojuego encontrado: {}", videojuego);
		} else {
			log.error("No existe un videojuego con el codigo {}", codigo);
		}
	}
}