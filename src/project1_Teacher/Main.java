package project1_Teacher;

import java.sql.SQLException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws SQLException  {
		
		Scanner input = new Scanner(System.in);
		
		for (;;) {
			
			
			
			System.out.println("press 1 for new student registration :");
			System.out.println("press 2 for take attendence:");
			System.out.println("press 3 for put CT mark :");
			System.out.println("press 4 for see result :");
			System.out.println("press 5 for delete student record :");
			System.out.println("press 6 for quit :");
			
			System.out.println("\nSelect your choice :\n");
			
			

			int choice;
			choice=input.nextInt();
			
			if (choice == 1) 
			{
				NewRegistration obj1 = new NewRegistration();
				obj1.registration();
			}
			else if (choice == 2)
			{
				Attendence obj2 = new Attendence();
				obj2.InsertAttendence();
			}
			else if (choice == 3)
			{
				CTMark obj3 = new CTMark();
				obj3.SetCTMark();
			}
			else if (choice == 4)
			{
				System.out.println("press 1 for entering theory exam mark :\n");
				System.out.println("press 2 to see complete result :\n");
				//System.out.println("press 3 to see overall result :\n");
				
				int res;
				res=input.nextInt();
				
				Result obj4=new Result();
				
				if(res==1)
					obj4.Set_Mark();
				else
					obj4.display();
			}
			else if (choice == 5)
			{
				DeleteRecord obj5=new DeleteRecord();
				obj5.Delete();
			}
			
			
			else if (choice == 6)
				break;
			
			
			//input.close();
			
		}
		input.close();
	}

}
