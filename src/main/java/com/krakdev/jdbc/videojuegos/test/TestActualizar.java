package com.krakdev.jdbc.videojuegos.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.jdbc.videojuegos.VideojuegoJdbc;
import com.krakdev.videojuegos.entidades.Videojuego;

public class TestActualizar {

	private static final Logger log = LogManager.getLogger(TestActualizar.class);

	public static void main(String[] args) {

		Videojuego videojuego = new Videojuego("VG001", "Minecraft Deluxe", "PC", 49.99, true, "Sandbox");

		Videojuego actualizado = VideojuegoJdbc.actualizar(videojuego);

		if (actualizado != null) {
			log.info("Videojuego actualizado correctamente: {}", actualizado);
		} else {
			log.error("No fue posible actualizar el videojuego");
		}
	}
}