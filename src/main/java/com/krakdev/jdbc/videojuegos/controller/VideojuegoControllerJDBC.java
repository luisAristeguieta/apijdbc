package com.krakdev.jdbc.videojuegos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakdev.jdbc.videojuegos.services.ServicioVideojuegoJdbc;
import com.krakdev.videojuegos.entidades.Videojuego;

@RestController
@RequestMapping("/videojuegos/jdbc")
public class VideojuegoControllerJDBC {

	private final ServicioVideojuegoJdbc servicioVideojuegoJdbc;

	public VideojuegoControllerJDBC(ServicioVideojuegoJdbc servicioVideojuegoJdbc) {
		this.servicioVideojuegoJdbc = servicioVideojuegoJdbc;
	}

	@PostMapping
	public Videojuego crear(@RequestBody Videojuego videojuego) {
		return servicioVideojuegoJdbc.crear(videojuego);
	}

	@GetMapping
	public List<Videojuego> listar() {
		return servicioVideojuegoJdbc.listar();
	}

	@GetMapping("/{codigo}")
	public Videojuego buscar(@PathVariable String codigo) {
		return servicioVideojuegoJdbc.buscarPorCodigo(codigo);
	}

	// Actualizar videojuego (Tener en consideracion que le paso el codigo del video
	// juego en el objeto cumpliendo con la misma funcion sin la PathVariable)
	@PutMapping
	public Videojuego actualizar(@RequestBody Videojuego videojuegoActualizado) {
		return servicioVideojuegoJdbc.actualizar(videojuegoActualizado);
	}

	@DeleteMapping("/{codigo}")
	public boolean eliminar(@PathVariable String codigo) {
		return servicioVideojuegoJdbc.eliminar(codigo);
	}
}