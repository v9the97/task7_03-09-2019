import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class JDBCWithFunction {
	public Connection con=null;
	
	public Scanner sc=new Scanner(System.in);
	public JDBCWithFunction() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod", "root", "root");
		
	}
	

	public void searchsalary() throws SQLException
	{
		int sal=0;
		 CallableStatement callable=con.prepareCall("{?=call salary (?)}");
		 System.out.println("please enter employee number here ");
		 sal=sc.nextInt();
		 callable.setInt(2,sal);
		 
		 callable.registerOutParameter(1, Types.INTEGER);
		 callable.execute();
		System.out.println(" employee number "+sal +" salary  "+ callable.getInt(1));
	}

	
	public static void main(String[] args) throws Exception {
		
JDBCWithFunction jdbcwithfunction=new JDBCWithFunction();
jdbcwithfunction.searchsalary();
	}

}
