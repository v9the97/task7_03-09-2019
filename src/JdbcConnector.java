import java.sql.*;

public class JdbcConnector {

	public static void main(String[] args) {
		String CREATE_TABLE_SQL = "CREATE TABLE vinod.emp1 (" + "empno INT NOT NULL primary key," + "NAME VARCHAR(45),"
				+ "DEPTNAME VARCHAR(45))";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod", "root", "root");

			Statement stmt = con.createStatement();
			
			
//------------------------Table Create----------------------------------

			 stmt.executeUpdate(CREATE_TABLE_SQL);
		  System.out.println("table created");
		  
		 

		// ------------------------Table emp1 Alter----------------------------------

		 String query1 = "aLTER TABLE emp1 ADD Address varchar(30)";

		 stmt.execute(query1);

		 
			
			//-----------------------Data insert into table----------------------------------

			 
			int rs1 = stmt.executeUpdate("insert into emp1 values(1,'vijay',56,'ujjain')");
			int rs2 = stmt.executeUpdate("insert into emp1 values(2,'vijay',56,'indore')");

			System.out.println("inserted ");
			
			

              //------------------------Select Data from table emp1----------------------------------

			ResultSet rs = stmt.executeQuery("select * from emp1");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}
			
			

                 //------------------------Data Delete from Table emp1----------------------------------

		String sql = "DELETE FROM emp1 " + "WHERE empno = 2";
		stmt.executeUpdate(sql);
		System.out.println("data deleted ");

		
		//------------------------Data Update from Table emp1----------------------------------
	
			String sql1 = "update  emp1 set empno=3 WHERE empno = 1";
		stmt.executeUpdate(sql1);
			System.out.println("Table updated ");
			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}

	}
}
