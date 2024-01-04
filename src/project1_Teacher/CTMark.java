package project1_Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.*;
public class CTMark extends Attendence {

	Attendence obj=new Attendence();
	
	Connection con;
	DataBase db=new DataBase();
	
	CTMark()throws SQLException
	{
		this.con=db.con;
	}
	public void SetCTMark() throws SQLException
	{
		this.con=db.con;
		int id,mark,choice;
        String name,sql;
        
        Scanner input=new Scanner(System.in);
        
        System.out.println("press 1 for ct1\n2 for ct2\n3 for ct3");
        choice=input.nextInt();
        
        /*if(choice==1)
        	sql="insert into ct(Id,Name,CT1,CT2,CT3) values (?,?,?,?,?)";
        else if(choice==2)
        	sql="update ct set CT2=? where Id=?";
        else
        	sql="UPDATE ct SET CT3=? where Id=?";*/
        
        for(Map.Entry<Integer, String> k:mp.entrySet())
        {
        	id=k.getKey();
        	name=k.getValue();
        	
        	if(choice==1)
	        	sql="insert into ct(Id,Name,CT1,CT2,CT3) values (?,?,?,?,?)";
	        else if(choice==2)
	        	sql="update ct set CT2=? where Id="+id;
	        else
	        	sql="UPDATE ct SET CT3=? where Id="+id;
        	
        	System.out.println("id: "+id+ " mark : ");
        	mark=input.nextInt();
        	
        	PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
        	if(choice==1)
        	{
        		ps.setInt(1, id);
    			ps.setString(2, name);
    			ps.setInt(3, mark);
    			ps.setInt(4, 0);
    			ps.setInt(5, 0);
    			//ps.executeUpdate();
        		
        	}
        	else
        	{
        		//ps.setInt(1, id);
        		ps.setInt(1, mark);
        		//ps.executeQuery();
        	}
        	ps.executeUpdate();
        	
        }
        //con.close();
        //input.close();
	}
}
