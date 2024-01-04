package project1_Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class DeleteRecord extends Attendence {

	Connection con;
	DataBase db=new DataBase();
	DeleteRecord() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
		this.con=db.con;
	}
	
	//show student
	private void Show()
	{
		for(Map.Entry<Integer, String> k:mp.entrySet())
		{
			System.out.println("Id : "+k.getValue()+" Name : "+k.getKey()+"\n");
		}
		
		System.out.println("\n\n");
	}
	
	//delete student
	private void DeleteId(int id)throws SQLException
	{
		String sql,sql2,sql3,sql4;
		sql="delete from student";
		PreparedStatement ps;
		
		sql="delete from student where Id="+id;
		ps=(PreparedStatement)con.prepareStatement(sql);
		ps.executeUpdate();
		
		sql2="delete from attendence where Id="+id;
		ps=(PreparedStatement)con.prepareStatement(sql2);
		ps.executeUpdate();
		
		sql3="delete from result where Id="+id;
		ps=(PreparedStatement)con.prepareStatement(sql3);
		ps.executeUpdate();
		
		sql4="delete from attendence";
		ps=(PreparedStatement)con.prepareStatement(sql4);
		ps.executeUpdate();
		
		System.out.println("Successfylly deleted\n\n");
		
	}
	
	public void Delete() throws SQLException
	{
		Scanner input=new Scanner(System.in);
		for(;;)
		{
			System.out.println("Show all student : press 1");
			System.out.println("Delete all student : press 2");
			System.out.println("Delete specefic student : press 3");
			
			PreparedStatement ps;
			
			String sql="",sql2="",sql3="",sql4="";
			int id,n=input.nextInt();
			
			if(n==1)
				Show();
			else if(n==2)
			{
				sql="delete from student";
				ps=(PreparedStatement)con.prepareStatement(sql);
				ps.executeUpdate();
				
				sql2="delete from attendence";
				ps=(PreparedStatement)con.prepareStatement(sql2);
				ps.executeUpdate();
				
				sql3="delete from result";
				ps=(PreparedStatement)con.prepareStatement(sql3);
				ps.executeUpdate();
				
				sql4="delete from attendence";
				ps=(PreparedStatement)con.prepareStatement(sql4);
				ps.executeUpdate();
				
				System.out.println("Successfylly deleted all students\n");
				break;
			}
			
			else if(n==3)
			{
				for(;;)
				{
					System.out.println("Enter Student id : ");
					id = input.nextInt();
					DeleteId(id);

					System.out.println("Do you want delete another ? 1 : Yes \n0 : No\n");

					int choice = input.nextInt();
					if (choice == 0)
						break;
				}
				break;
			}
			
			
		}
		
		
	}

}
