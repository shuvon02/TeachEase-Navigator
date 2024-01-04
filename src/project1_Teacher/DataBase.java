package project1_Teacher;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	public String conn, s, rt;
	public Connection con;

	DataBase()
	{
		try
		{
			conn="com.mysql.cj.jdbc.Driver";
			Class.forName(conn);
			s = "jdbc:mysql://localhost:3308/project1_teacher";
			rt="root";
			con= DriverManager.getConnection(s,rt,"");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
