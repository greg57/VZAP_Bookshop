package vzap.greg.dao;

import java.sql.*;

public class LoginDAO
{
	public static boolean validate(String name, String pass)
	{
		boolean status = false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vzapbookshop_db", "root", "root");

			PreparedStatement ps = con.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		}
		catch (Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		return status;
	}
}
