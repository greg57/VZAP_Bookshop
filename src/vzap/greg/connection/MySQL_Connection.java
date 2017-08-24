package vzap.greg.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SuppressWarnings("all")
public class MySQL_Connection
{
	private Properties dbProperties = null;
	private String username = null;
	private String password = null;
	private String databaseName = null;
	private String ipAddress = null;
	private String portNumber = null;
	private String url = null;

	private Connection connection = null;

	public MySQL_Connection() throws ClassNotFoundException, SQLException, IOException
	{
		dbProperties = new Properties();
		InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/dbConfig.properties");
		if(in == null)
		{
			FileInputStream input = new FileInputStream("./resources/dbConfig.properties");
			// load a properties file
			dbProperties.load(input);
			input.close();
		}
		else
		{
			dbProperties.load(in);
			in.close();
		}

		this.username = dbProperties.getProperty("username");
		this.password = dbProperties.getProperty("password");
		this.databaseName = dbProperties.getProperty("databasename");
		this.ipAddress = dbProperties.getProperty("ipAddress");
		this.portNumber = dbProperties.getProperty("portnumber");
		url = "jdbc:mysql://" + this.ipAddress + ":" + this.portNumber + "/" + this.databaseName;
		System.out.println("url = " + url);

		Class.forName("com.mysql.jdbc.Driver");

		connection = DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":3306/" + databaseName, username,
				password);
		System.out.println("Connection to database made...>>>>>>");
	}

	public Connection getConnection()
	{
		return connection;
	}

	public void closeConnection() throws SQLException
	{
		connection.close();
	}
}
