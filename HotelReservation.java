package Database;
import java.sql.*;
import java.util.Scanner;

public class HotelReservation {

	
	Connection con;
	Statement stmt;
	public void connection()
	{
		String url="jdbc:mysql://localhost:3306/hotel_db";
		String root="root";
		String pass="omsairam";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		try
		{
			 con=DriverManager.getConnection(url,root,pass);
			stmt= con.createStatement();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void newreservation()
	{
		try
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter gest name:");
		String name=sc.next();
		System.out.println("Enter gest room_number:");
		int n=sc.nextInt();
		System.out.println("Enter gest contect_number:");
		String con_num=sc.next();
		String query="insert into reservation(gest_name,room_number,contect_number) values('"+name+"',"+n+",'"+con_num+"');";
		int  rs=stmt.executeUpdate(query);
		if(rs>0)
		{
			
		}
		}catch(Exception e)
		{
			System.out.println(" col"+e);
		}

	}
	public void chackreservation()
	{
		try {
		ResultSet rs1=stmt.executeQuery("select * from reservation;");
		System.out.println("======================================================================");
				while(rs1.next())
		{
	   System.out.println("======================================================================");
		System.out.println("|id:" +rs1.getInt(1)+"|\nname:"+rs1.getString(2)+"|\nroom_number"+rs1.getInt(3)+"|\ncontect_numbe:"+rs1.getString(4)+"|\ndate:"+rs1.getTimestamp(5)+"|");
		}
		}catch(Exception e)
		{
			System.out.println("hello"+e);
		}
	}

	public void updatereservation()
	{
		try
		{
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("What is update ,if change room_number then input-1 or name input-2 contect_number input-3 :");
	     int res=sc.nextInt();
		if(res==1)
		{ 	
		System.out.println("Enter id");
		int i=sc.nextInt();	
		System.out.println("Enter room_number");
		int r=sc.nextInt();
		String query="UPDATE reservation set  room_number ="+r+" WHERE resevation_id="+i+";";
        int update=stmt.executeUpdate(query);
			
        if(update>0)
        {
        	System.out.println("exicute query ");
        	
        }
        else
        {
        	System.out.println("not exitu query");
        }
		}else if(res==2)
		{
			System.out.println("Enter id");
			int i=sc.nextInt();	
			System.out.println("Enter name ");
			String r=sc.next();
			String query="UPDATE reservation set  gest_name ='"+r+"' WHERE resevation_id="+i+";";
	        int update=stmt.executeUpdate(query);      
		}
		else
		{
			System.out.println("Enter id");
			int i=sc.nextInt();	
			System.out.println("Enter contect number");
			String r=sc.next();
			String query="UPDATE reservation set  contect_number ='"+r+"' WHERE resevation_id="+i+";";
	        int update=stmt.executeUpdate(query);
		}
		   }catch(Exception e )
		   {
			System.out.println(e);
		  }
	}
	
	public void delete() 
	{
		try
		{Scanner sc=new Scanner(System.in);
		System.out.println("Enter delite id number:");
		int i=sc.nextInt();
		String query="delete from reservation where resevation_id="+i+";";
		int st=stmt.executeUpdate(query);
	    }catch(Exception e)
		{
		System.out.println(e);
		}

}
}
