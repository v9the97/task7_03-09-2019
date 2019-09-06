import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCWithProcedure {

	public Connection con=null;
	Statement stmt=null;
	public Scanner sc=new Scanner(System.in);

		public JDBCWithProcedure () throws Exception
		{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod", "root", "root");

			 stmt = con.createStatement();
			
		}
		//---------------------procedure use in this function for the insertion 
		public void Add() throws SQLException {
			System.out.println("please insert employee must be unique otherwise your insertion will not be submit ");
			System.out.println("enter employeeno, employeename,salary,departmentname");
			 CallableStatement callable=con.prepareCall("call addone(?,?,?,?)"); // call procedure here 
			 callable.setInt(1,sc.nextInt());
			 callable.setString(2, sc.next());
			 callable.setInt(3,sc.nextInt());
			 callable.setString(4, sc.next());
			 callable.execute();
			 System.out.println("data successfully insert into the database");
		
		}
		
		
	public static void main(String[] args) throws Exception {
		JDBCWithProcedure jdbcprocedur=new JDBCWithProcedure();
		jdbcprocedur.Add();

	}

}
