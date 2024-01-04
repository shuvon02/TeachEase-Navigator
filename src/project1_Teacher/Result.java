package project1_Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.*;

public class Result extends Attendence {
	Attendence obj=new Attendence();
	Connection con;
	DataBase db=new DataBase();
	Result()throws SQLException
	{
		this.con=db.con;
	}
	
	public void display() throws SQLException 
	{
		String sql="select Id,Name,CT,Attendence,Total_30,Grade from result";
        int id,ct,attendence,total_30;
        String name,grade;
        
        PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        System.out.println("ID	Name	CT	Attendence	Total_30	Grade ");
        while(rs.next())
        {
        	id=rs.getInt("Id");
        	name=rs.getString("Name");
        	ct=rs.getInt("CT");
        	attendence=rs.getInt("Attendence");
        	total_30=rs.getInt("Total_30");
        	grade=rs.getString("Grade");
        	
        	System.out.println(id+ " "+name+ " "+ct+" "+attendence+" "+total_30+" "+grade);
        	System.out.println('\n');
        	
        }
        System.out.println('\n'+'\n');
	}
	
	//finding ct mark
	private int Get_CT(int id) throws SQLException 
	{
		int max_ct=0;
		String sql="select CT1,CT2,CT3 from CT where Id="+id;
        PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        
        int ct1,ct2,ct3;
        int tmp1,tmp2;
        if(rs.next())
        {
        	ct1=rs.getInt("CT1");
        	ct2=rs.getInt("CT2");
        	ct3=rs.getInt("CT3");
        	tmp1= Math.max(ct2, ct3);
        	tmp2=Math.min(ct2, ct3);
        	
        	max_ct=(tmp1+Math.max(ct1, tmp2))/2;
        }
		return max_ct;
	}
	
	//getting attendence
	private int Get_Attendence(int id) throws SQLException
	{
		int attendence=1;
		 //find total sutdent
        int total_student=1;
        String sql="select count(*) as total from student";
        PreparedStatement ps=(PreparedStatement)con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
        	total_student=rs.getInt("total");
        	//System.out.println(total_student);
        }
        
        /*need to calculate number of classes:
        using counting number of rows in attendence table,then divide the
        number of class by total sutdent..then find total attend class of id,finally calculate*/
        
        //find total number of class
        int total_class=1;
        String sql2="select count(*) as total_class from attendence";
        ps=(PreparedStatement)con.prepareStatement(sql2);
        rs=ps.executeQuery();
        if(rs.next())
        	total_class=rs.getInt("total_class");
        
        //System.out.println("tc = "+total_class);
        //System.out.println("ts = "+total_student);
        total_class/=total_student;
        
        //find total class attend of id
        int id_class_attend=1;
        String sql3="select NoClassAttend from attendence where Id="+id;
        ps=(PreparedStatement)con.prepareStatement(sql3);
        rs=ps.executeQuery();
        if(rs.next())
        	id_class_attend=rs.getInt("NoClassAttend");
        
       //System.out.print("id_att = "+id_class_attend);
        //final calculation
        attendence=(id_class_attend*10/total_class);
        //System.out.print("att = "+attendence);
		return attendence;
	}
	
	//find grade of id
	private String GetGrade(int mark) {
		String grade="";
		if(mark>=80)
			grade="A+";
		else if(mark<80 && mark>=75)
			grade="A";
		else if(mark<75 && mark>=70)
			grade="A-";
		else if(mark<70 && mark>=65)
			grade="B+";
		else if(mark<65 && mark>=60)
			grade="B";
		else if(mark<60 && mark>=55)
			grade="C+";
		else if(mark<55 && mark>=50)
			grade="C";
		else if(mark<50 && mark>=45)
			grade="D+";
		else if(mark<45 && mark>=40)
			grade="D";
		else
			grade="F";
		
		return grade;
	}
	
	//setting result
	public void Set_Mark() throws SQLException
	{
		
		Scanner input=new Scanner(System.in);
		
		int id,theory,ct,attendence=1,total_30;
		String name,grade;
		
		String sql;
		
		PreparedStatement ps;
		
		//System.out.println("shuvon");
		
		for(Map.Entry<Integer, String> k:mp.entrySet())
		{
			id=k.getKey();
			name=k.getValue();
			
			ct=Get_CT(id);
			attendence=Get_Attendence(id);
			System.out.println("Atten " +attendence);
			total_30=ct+attendence;
			//grade=GetGrade(id);
			
			sql="insert into result(Id,Name,CT,Attendence,Total_30,Theory,Grade) values (?,?,?,?,?,?,?)";
			
			ps=(PreparedStatement)con.prepareStatement(sql);
			
			System.out.println("id : "+id+" Theory mark :\n");
			theory=input.nextInt();
			grade=GetGrade(total_30+theory);
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setInt(3,ct);
			ps.setInt(4,attendence);
			ps.setInt(5,total_30);
			ps.setInt(6,theory);
			ps.setString(7,grade);
			
			ps.executeUpdate();
		}
		//input.close();
		//con.close();
		
	}
}
