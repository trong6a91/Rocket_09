package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {
	private Properties properties;
	private Connection connection;

	public JDBC() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		properties = new Properties();
		properties.load(new FileInputStream("src/main/resource/databases.properties"));
		connect();
	}

	public Connection connect() throws ClassNotFoundException, SQLException {
		if (connection != null && !connection.isClosed()) {
			return connection;
		}

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
	
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}