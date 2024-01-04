package project1_Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NewRegistration {
	Connection con;
	DataBase db=new DataBase();
	NewRegistration()
	{
		this.con=db.con;
	}
	public void registration() throws SQLException 
	{
		for(;;)
        {

        	Scanner input=new Scanner(System.in);

        	String name,dept,session;
        	int id;

        	System.out.println("enter name");
        	name=input.next();

        	System.out.println("enter id");
        	id=input.nextInt();

        	System.out.println("enter dept");
        	dept=input.next();

        	System.out.println("enter session");
        	session=input.next();

        	String sql="insert into student(Name,Id,Dept,Session) values (?,?,?,?)";;

        	PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
        	ps.setString(1, name);
        	ps.setInt(2, id);
        	ps.setString(3, dept);
        	ps.setString(4, session);

        	ps.executeUpdate();

        	System.out.println("Successfuly Registerd");

        	System.out.println("Do you want to register another ?\n1 for yes :\n0 for no :\n");

        	int x;

        	x=input.nextInt();
        	if(x==0)break;
        	
        	//input.close();
        	//con.close();
        }
	}
}
