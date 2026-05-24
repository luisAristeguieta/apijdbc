package com.krakdev.jdbc.videojuegos.test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.jdbc.videojuegos.VideojuegoJdbc;
import com.krakdev.videojuegos.entidades.Videojuego;

public class TestListar {

	private static final Logger log = LogManager.getLogger(TestListar.class);

	public static void main(String[] args) {

		List<Videojuego> videojuegos = VideojuegoJdbc.listar();

		for (Videojuego videojuego : videojuegos) {
			log.info(videojuego);
		}
	}
}