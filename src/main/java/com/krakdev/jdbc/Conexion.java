package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {
private static final Logger log = LogManager.getLogger(Conexion.class);
	
	private static final String url = "jdbc:postgresql://localhost:5432/apijdbc";
	private static final String user = "postgres";
	private static final String password = "6545319Aa@";

	public static Connection getConnection() {

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			log.info("Conexion exitosa");
			return con;
		} catch (SQLException e) {
			log.error("Error de conexion " + e.getMessage());
			throw new RuntimeException("No se pudo conectar",e);
		}	
	}
}
