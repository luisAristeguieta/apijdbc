package com.krakdev.jdbc.videojuegos.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.jdbc.videojuegos.VideojuegoJdbc;
import com.krakdev.videojuegos.entidades.Videojuego;

public class TestInsertar {

	private static final Logger log = LogManager.getLogger(TestInsertar.class);

	public static void main(String[] args) {

		Videojuego videojuego = new Videojuego("VG002", "Minecraft 2", "PC 2", 39.99, true, "Sandbox 2 ");
		Videojuego resultado = VideojuegoJdbc.crear(videojuego);
	}
}