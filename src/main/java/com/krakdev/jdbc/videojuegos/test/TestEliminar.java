package com.krakdev.jdbc.videojuegos.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.jdbc.videojuegos.VideojuegoJdbc;

public class TestEliminar {

	private static final Logger log = LogManager.getLogger(TestEliminar.class);

	public static void main(String[] args) {

		String codigo = "VG002";

		boolean eliminado = VideojuegoJdbc.eliminar(codigo);

		if (eliminado) {
			log.info("Videojuego eliminado correctamente");
		} else {
			log.error("No fue posible eliminar el videojuego");
		}
	}
}