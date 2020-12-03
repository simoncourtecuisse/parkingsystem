package com.parkit.parkingsystem.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataBaseConfig {

	private static final Logger logger = LogManager.getLogger("DataBaseConfig");

	public Connection getConnection() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		logger.info("Create DB connection");
		Class.forName("com.mysql.cj.jdbc.Driver");

		Properties properties = new Properties();
		properties.load(new FileInputStream(new File("src/main/resources/credentials.properties")));
		String url = properties.getProperty("url");
		String user = properties.getProperty("username");
		String pass = properties.getProperty("password");
		return DriverManager.getConnection(url, user, pass);

	}

	public void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
				logger.info("Closing DB connection");
			} catch (SQLException e) {
				logger.error("Error while closing connection", e);
			}
		}
	}

	public void closePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
				logger.info("Closing Prepared Statement");
			} catch (SQLException e) {
				logger.error("Error while closing prepared statement", e);
			}
		}
	}

	public void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				logger.info("Closing Result Set");
			} catch (SQLException e) {
				logger.error("Error while closing result set", e);
			}
		}
	}
}
