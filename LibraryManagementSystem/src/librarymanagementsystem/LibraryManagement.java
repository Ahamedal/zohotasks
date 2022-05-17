package librarymanagementsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryManagement {
 DBLayer d=new DBLayer();
	
	List<Integer> lis=new ArrayList<>();
	
	
	public void createTable() {
		d.createTable();
	}
	public void addBook(Book bookObj) {
		d.addBook(bookObj);
	}
	public List<Book> searchByAuthor(String name){
		return d.searchByAuthor(name);
	}
	public List<Book> searchByTitle(String name){
		return d.searchByTitle(name);
	}
	public List<Book> searchBySubject(String name){
		return d.searchBySub(name);
	}
	public Book bookCheckOut(String bookTitle,String authorName) {
		if(d.bookCheckOut(bookTitle,authorName).size()==0) {
			return null;
		}
		else {
			return d.bookCheckOut(bookTitle,authorName).get(0);
		}
	}
	public void addMember(String name,String emailId,long mNo) {
		d.addMember(name,emailId,mNo);
	}
	public String currentTime() {
		long currentTime=System.currentTimeMillis();
		SimpleDateFormat si=new SimpleDateFormat("hh:mm:ss");
		Date dateObj=new Date(currentTime);
		return si.format(dateObj);
	}
	//public String returnTime() {
		
	//}
	public void addIssueBook(int bookId,String email) {
		//d.addIssueBook(bookId,email,currentTime());
	}
	public void updateMember(String emailId) {
		d.updateMember(emailId);
	}
	public void changeStatus(int bookId) {
		d.changeStatus(bookId);
	}
}
