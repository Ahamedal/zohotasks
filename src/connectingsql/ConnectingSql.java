package connectingsql;
import java.sql.*;


import java.util.*;

public class ConnectingSql {
	String url="jdbc:mysql://localhost:3306/zoho";
	String uName="root";
	String pass="K@r0!KuD!";
	public void createTable() {
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
		Statement st=con.createStatement();){
			String query="create table employee(name varchar(25),city varchar(25),age int);";
		
		  int count=st.executeUpdate(query);
			  System.out.println(count+"table Created");
		  
		  
		
	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void insertTable(String query) {
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
				Statement st=con.createStatement();){
         
				
				  int count=st.executeUpdate(query);
					  System.out.println(count+"rows Created");
				  
				  }
				catch(SQLException e) {
					e.printStackTrace();
				}
		
	}
	public void selectTable() {
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
				Statement st=con.createStatement();){
         String query="select * from employee;";
				String result="";
				  ResultSet rs=st.executeQuery(query);
					  while(rs.next()) {
						  result=rs.getString(1)+":"+rs.getString(2)+":"+rs.getInt(3);
					  }
					  System.out.println(result);
				  
				  }
				catch(SQLException e) {
					e.printStackTrace();
				}
		
		
	}
	public void updateTable() {
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
				Statement st=con.createStatement();){
         String query="update employee set name='kruju' where city='karur'";
				String result="";
				  int count=st.executeUpdate(query);
				  System.out.println(count+"rows affected");
					  
				  
				  }
				catch(SQLException e) {
					e.printStackTrace();
				}
		
		
	}
	public void deleteTable() {
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
				Statement st=con.createStatement();){
         String query="delete from employee where city='karur'";
				String result="";
				  int count=st.executeUpdate(query);
				  System.out.println(count+"rows affected");
					  
				  
				  }
				catch(SQLException e) {
					e.printStackTrace();
				}
		
	}
		public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		ConnectingSql obj=new ConnectingSql();
		Scanner sc=new Scanner(System.in);
		int quesNo=sc.nextInt();
		switch(quesNo) {
		case 1:
			obj.createTable();
			break;
		case 2:
			System.out.println("how many values do you want insert");
			int no=sc.nextInt();
			sc.nextLine();
			for(int i=0;i<no;i++) {
			System.out.println("enter queries");
			String query=sc.nextLine();
			
			obj.insertTable(query);
			}
			break;
		case 3:
			obj.selectTable();
			break;
		case 4:
			obj.updateTable();
			break;
		case 5:
			obj.deleteTable();
			break;
			
	
		}
	}
	
	
		
	}


