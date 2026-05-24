package com.krakdev.jdbc.videojuegos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.jdbc.Conexion;
import com.krakdev.videojuegos.entidades.Videojuego;

public class VideojuegoJdbc {

	private static final Logger log = LogManager.getLogger(VideojuegoJdbc.class);

	public static Videojuego buscar(String codigoC) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Videojuego videoJuego = null;

		String sql = """
				select * from videojuegos where codigo = ?
				""";

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, codigoC);

			rs = ps.executeQuery();

			if (rs.next()) {
				String codigo = rs.getString("codigo");
				String nombre = rs.getString("nombre");
				String plataforma = rs.getString("plataforma");
				double precio = rs.getDouble("precio");
				boolean disponible = rs.getBoolean("disponible");
				String genero = rs.getString("genero");

				videoJuego = new Videojuego(codigo, nombre, plataforma, precio, disponible, genero);
				log.info("Video Juego Encontrado");

			}
		} catch (SQLException e) {
			log.error("Error SQL al buscar Video Juego: ", e);
			throw new RuntimeException("Error al buscar Video Juego: " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
					log.info("ResultSet cerrado al buscar");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar ResultSet al buscar: " + e.getMessage());
			}
			try {
				if (ps != null) {
					ps.close();
					log.info("PreparedStatement cerrado al buscar");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar PreparedStatement al buscar: " + e.getMessage());
			}
			try {
				if (con != null) {
					con.close();
					log.info("Conexion cerrada al buscar");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar Connection al buscar: " + e.getMessage());

			}
		}

		if (videoJuego == null) {
			log.info("No existe el Video Juego con el codigo: " + codigoC);
		}
		return videoJuego;
	}

	public static Videojuego crear(Videojuego videoJuego) {

		Videojuego videoJuegoConsultado = buscar(videoJuego.getCodigo());

		if (videoJuegoConsultado != null) {
			log.info("Video Juego con codigo: " + videoJuego.getCodigo() + " ya se encuentra regitrado");
			return null;
		}

		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
				insert into videojuegos (codigo,nombre,plataforma,precio,disponible,genero)
				values (?,?,?,?,?,?)
				""";

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, videoJuego.getCodigo());
			ps.setString(2, videoJuego.getNombre());
			ps.setString(3, videoJuego.getPlataforma());
			ps.setDouble(4, videoJuego.getPrecio());
			ps.setBoolean(5, videoJuego.isDisponible());
			ps.setString(6, videoJuego.getGenero());

			int filas = ps.executeUpdate();
			log.info("Video Juego(s) agregado(s) correctamente: " + filas);

		} catch (SQLException e) {
			log.error("Error SQL al crear Video Juegoe", e);
			throw new RuntimeException("Error al crear Video Juego" + e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
					log.info("PreparedStatement cerrado al crear");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar PreparedStatement al crear " + e.getMessage());
			}
			try {
				if (con != null) {
					con.close();
					log.info("Conexion cerrada al crear");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar Connection al crear: " + e.getMessage());

			}
		}
		return videoJuego;
	}

	public static List<Videojuego> listar() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Videojuego> videojuegos = new ArrayList<>();

		String sql = """
				select * from videojuegos
				""";

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {

				String codigo = rs.getString("codigo");
				String nombre = rs.getString("nombre");
				String plataforma = rs.getString("plataforma");
				double precio = rs.getDouble("precio");
				boolean disponible = rs.getBoolean("disponible");
				String genero = rs.getString("genero");

				Videojuego videojuego = new Videojuego(codigo, nombre, plataforma, precio, disponible, genero);

				videojuegos.add(videojuego);
			}

			log.info("Listado de videojuegos realizado");
		} catch (SQLException e) {
			log.error("Error SQL al listar videojuegos", e);
			throw new RuntimeException("Error al listar videojuegos: " + e.getMessage());

		} finally {

			try {
				if (rs != null) {
					rs.close();
					log.info("ResultSet cerrado al listar");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar ResultSet al listar: " + e.getMessage());
			}

			try {
				if (ps != null) {
					ps.close();
					log.info("PreparedStatement cerrado al listar");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar PreparedStatement al listar: " + e.getMessage());
			}

			try {
				if (con != null) {
					con.close();
					log.info("Conexion cerrada al listar");
				}
			} catch (SQLException e) {
				log.error("Error al cerrar Connection al listar: " + e.getMessage());
			}
		}
		return videojuegos;
	}
}
