package librarymanagementsystem;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DBLayer {
	String url="jdbc:mysql://localhost:3306/LibraryManagement";
	String uName="root";
	String pass="K@r0!KuD!";
	
	public void createTable() {
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
		Statement st=con.createStatement();){
			  
			  String query1="create table Book(BookId int not null auto_increment,Title varchar(25),Author varchar(25),Subject varchar(25),PublicationDate varchar(25),RackNo int,Status tinyint,primary key(BookId))";
			  String query2="create table Member(MemberId varchar(25),MemberName varchar(25),MobileNumber bigint,NonReturnedBooks int,primary key(MemberId))";
			  String query3="create table IssueBook(BookId int not null,MemberId varchar(25),IssueDate bigint,DueDate bigint,DayElapse bigint,fine float,foreign key(BookId) references Book(BookId),foreign key(MemberId) references Member(MemberId))";
		      int count1=st.executeUpdate(query1);
			  System.out.println(count1+"table Created");
			  int count2=st.executeUpdate(query2);
			  System.out.println(count2+"table created");
			  int count3=st.executeUpdate(query3);
			  System.out.println(count3+" table created");
		
		  
		
	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		}
	public void insertTable(String query) {
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
    			Statement st=con.createStatement();){
		        st.executeUpdate(query)	;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Book> selectTable(String query){
		try(java.sql.Connection con=DriverManager.getConnection(url, uName, pass);
    			Statement st=con.createStatement();){
			ResultSet rs=st.executeQuery(query);
			List<Book> lis=new ArrayList<>();
			while(rs.next()) {
				Book bookObj=new Book();
				bookObj.setAuthor(rs.getString("Author"));
				bookObj.setBookTitle(rs.getString("Title"));
				bookObj.setPublicationDate(rs.getString("PublicationDate"));
				bookObj.setRackNo(rs.getInt("RackNo"));
				bookObj.setUniqueIdNumber(rs.getInt("BookId"));
				bookObj.setSubject(rs.getString("Subject"));
				lis.add(bookObj);
			}
			return lis;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public void addBook(Book bookObj) {
		String title=bookObj.getBookTitle();
		String author=bookObj.getAuthor();
		String sub=bookObj.getSubject();
		String publicationDate=bookObj.getPublicationDate();
		boolean available=bookObj.isAvailable();
		int rackNo=bookObj.getRackNo();
		insertTable("insert into Book (Title,Author,Subject,PublicationDate,RackNo,Status) values('"+title+"','"+author+"','"+sub+"','"+publicationDate+"',"+rackNo+","+available+");");
	}
	
	public void addIssueBook(int bookId,String memberId) {
		
//		String title=bookObj.getBookTitle();
//		String author=bookObj.getAuthor();
//		String sub=bookObj.getSubject();
//		long publicationDate=bookObj.getPublicationDate();
//		boolean available=bookObj.isAvailable();
//		int rackNo=bookObj.getRackNo();
//		insertTable("insert into IssueBook (Title,Author,Subject,PublicationDate,RackNo,Status) values('"+title+"','"+author+"','"+sub+"',"+publicationDate+","+rackNo+","+available+");");
	}
	public void addMember(String name,String emailId,long m) {
		insertTable("insert into Member(MemberName,MemberId,MobileNumber,nonReturnedBooks) values('"+name+"','"+emailId+"',"+m+","+0+");");
	}
	public void updateMember(String emailId) {
		insertTable("update Member set NonReturnedBooks=NonReturnedBooks+1 where MemberId='"+emailId+"'");
	}
	public List<Book> searchByAuthor(String name){
		return selectTable("select * from Book where Author='"+name+"';");
	}
	public List<Book> searchByTitle(String name){
		return selectTable("select * from Book where Title='"+name+"';");
	}
	public List<Book> searchBySub(String name){
		return selectTable("select * from Book where Subject='"+name+"';");
	}
	public List<Book> bookCheckOut(String bookTitle,String name){
		return selectTable("select * from Book where Title='"+bookTitle+"' and Author='"+name+"' and Status="+true+";");
	}
	public void changeStatus(int bookId) {
		insertTable("update Book set Status=false where BookId="+bookId);
	}
}
