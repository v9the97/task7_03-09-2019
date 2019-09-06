import java.sql.*;
import java.util.Scanner;

public class EmployeeWithDatabase {
public Connection con=null;
Statement stmt=null;
public Scanner sc=new Scanner(System.in);

	public EmployeeWithDatabase() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vinod", "root", "root");

		 stmt = con.createStatement();
		
	}
	

	



		public void Add() throws SQLException {
			System.out.println("enter employeeno, employeename,salary,departmentname");
			 CallableStatement callable=con.prepareCall("call addone(?,?,?,?)");
			 callable.setInt(1,sc.nextInt());
			 callable.setString(2, sc.next());
			 callable.setInt(3,sc.nextInt());
			 callable.setString(4, sc.next());
			 callable.execute();
		
		}
		
		
		

		public void viewAllEmp() throws SQLException {
			ResultSet rs = stmt.executeQuery("select * from employee");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}

		}
		
		

		public void Remove() throws SQLException {
			System.out.println(" please enter empno for deletion ");
			String sql = "DELETE FROM employee " + "WHERE empno = "+sc.nextInt();
			stmt.executeUpdate(sql);
			System.out.println("data deleted ");			
		}

		
		
		public void cleanData() throws SQLException {
			System.out.println("please enter Table NAme for delete ");
		 stmt.executeUpdate("truncate table ="+sc.next());
			
		}

		
		//------update employee information 
		
		public void Change() throws SQLException {
			int up;
			System.out.println(" please enter empno for updation ");
			up=sc.nextInt();
			System.out.println(" please enter empname,salary,departmentname for updation ");
			
			String sql1 = "update  employee set empname='"+sc.next()+"',salary= '"+sc.nextInt()+"',dert='"+sc.next()+"' WHERE empno = "+up;
			stmt.executeUpdate(sql1);
				System.out.println("Table updated ");
			
		}
		
		
		//------search  employee information 	

		public void search() throws SQLException {
			System.out.println("please enter employee number for search ");
			ResultSet rs = stmt.executeQuery("select * from employee where empno='"+sc.next()+"'");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}

		}
		
		
		//------search department wise employee information 

		public void DeptWise() throws SQLException {
			System.out.println("please enter DepartmentName for search ");
			ResultSet rs = stmt.executeQuery("select * from employee where dert='"+sc.next()+"'");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
			
		}
		
		//------	SORT  employee  DATA WITH EMPLOYEE NUMBER 
		
			public void sort() throws SQLException
			{
				System.out.println("sort by EmployeeNumber ");
				ResultSet rs = stmt.executeQuery("select * from employee order by empno");

				while (rs.next()) {
					System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
				}
			}
			
			
			//------SEARCH EMPLOYEE SALARY WITH A STORED FUNCTION WITH JAVA CODE 
			
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
		

			//------MAIN FUNCTION WITH A MENU DISPLAY TO THE USER WITH JAVA CODE 
			
		public static void main(String[] args) throws Exception {
			Scanner sc =new Scanner(System.in);
			
			EmployeeWithDatabase obj=new EmployeeWithDatabase ();
		boolean b = true;

		while (b) {
				System.out.print(" \n Menu \n ");
				System.out.print(" \n  1. Add Employee with stored procedure  ");
				System.out.print(" \n  2. View all employees  ");
				System.out.print(" \n  3. Remove Employee  ");
				System.out.print(" \n  4. Clean Data  ");
				System.out.print(" \n  5. Update all details   ");
				System.out.print(" \n  6. Search  ");
				System.out.print(" \n  7. View Departmnet wise employess  ");
				System.out.print(" \n  8. Sort By eno");
				System.out.print(" \n  9. search salary by function ");
				System.out.print(" \n  10. EXITS ");
				
				System.out.print(" Provide your choice as a number amongst these choices ");

				//------HERE MENU STARTED AND WE CALL FUNCTION ACCORDING TO USER CHOICE
				
				switch (sc.nextInt()) {
				case 1:
					obj.Add();
					break;
				case 2:
					obj.viewAllEmp();
					break;
				case 3:
					obj.Remove();
					break;
				case 4:
					obj.cleanData();
					break;

				case 5:
					obj.Change();
					break;

				case 6:
					obj.search();
					break;

				case 7:
					obj.DeptWise();
					break;

				case 8:
					obj.sort();
					break;
					
				case 9:
					obj.searchsalary();
					
				case 10 :
					b=false;
				default:
					System.out.print(" ");
					break;
				}
			}
	
		}

}
