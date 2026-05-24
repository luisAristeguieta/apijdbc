package com.krakdev.jdbc.videojuegos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakdev.jdbc.videojuegos.VideojuegoJdbc;
import com.krakdev.videojuegos.entidades.Videojuego;

@Service
public class ServicioVideojuegoJdbc {
	
	public Videojuego crear (Videojuego videojuego) {
		return VideojuegoJdbc.crear(videojuego);
	}
	
	public List<Videojuego> listar () {
		return VideojuegoJdbc.listar();
	}
	
	public Videojuego buscarPorCodigo (String codigo) {
		return VideojuegoJdbc.buscar(codigo);
	}
	
	public Videojuego actualizar (Videojuego videojuegoActualizado) {
		return VideojuegoJdbc.actualizar(videojuegoActualizado);
	}
	
	public boolean eliminar (String codigo) {
		return VideojuegoJdbc.eliminar(codigo);
	}
	
}
