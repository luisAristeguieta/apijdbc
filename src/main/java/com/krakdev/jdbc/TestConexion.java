package com.krakdev.jdbc;

import java.sql.Connection;

public class TestConexion {

	public static void main(String[] args) {

		Connection con = Conexion.getConnection();

	}
}