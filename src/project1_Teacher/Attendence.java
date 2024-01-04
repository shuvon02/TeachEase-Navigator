package project1_Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Attendence {
	public Map<Integer,String> mp=new HashMap<Integer,String>();
	
	DataBase db=new DataBase();
	Connection con;
	
	Attendence() throws SQLException
	{
		this.con=db.con;
		String sql="select * from student";
        PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
        
        ResultSet rs=ps.executeQuery();
        int id;
        String name;
        
        
        while(rs.next())
        {
        	id=rs.getInt("Id");
        	name=rs.getString("Name");
        	mp.put(id,name);
        }
	}
	
	
	public void InsertAttendence() throws SQLException
	{
		//String sql="select * from 4_2";
        
        PreparedStatement ps3,ps2;
        
        ResultSet rs2;
        
        String date,name,present;
        int id;
        
        Scanner input=new Scanner(System.in);
        
        for(;;)
        {

        	//date input
        	System.out.println("Enter date(xx/xx/xxxx)");
        	date=input.next();

        	int attendence;

        	for(Map.Entry<Integer,String> k:mp.entrySet())
        	{
        		id=k.getKey();
        		name=k.getValue();

        		attendence=0;

        		//getting attendence from attendence table
        		String sql2="select NoClassAttend from attendence where Id=?";
        		ps2=(PreparedStatement)con.prepareStatement(sql2);
        		ps2.setInt(1,id);

        		rs2=ps2.executeQuery();
        		if(rs2.next())
        		{
        			attendence=attendence+rs2.getInt("NoClassAttend");
        			//System.out.println(attendence);
        		}

        		System.out.println("id :"+id+" is present?\n1 for Yes:\n0 for No:\n");
        		int chk;
        		chk=input.nextInt();
        		if(chk==1)
        		{
        			present="Yes";
        			attendence++;
        		}

        		else
        			present="No";

        		//inserting data in 4th_year_attendence table
        		String sql3="insert into attendence(Id,Name,Date,Present,NoClassAttend) values(?,?,?,?,?)";
        		ps3=(PreparedStatement)con.prepareStatement(sql3);
        		ps3.setInt(1, id);
        		ps3.setString(2, name);
        		ps3.setString(3, date);
        		ps3.setString(4, present);
        		ps3.setInt(5, 0);
        		
        		//set attendence
        		ps3.executeUpdate();
        		String sql="update attendence set NoClassAttend=? where Id="+id;
        		ps3=(PreparedStatement)con.prepareStatement(sql);
        		ps3.setInt(1, attendence);
        		ps3.executeUpdate();
        	}
        	
        	System.out.println("Want to take another present ? \n1 for yes :\n0 for no :\n");
        	int choice;
        	choice=input.nextInt();
        	if(choice!=1)
        		break;
        	
        }
        //input.close();
	}
	
}
