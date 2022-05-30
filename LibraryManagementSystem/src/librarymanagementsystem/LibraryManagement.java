package librarymanagementsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	public void reserveBook(int bookId,String emailId) {
		d.reserveBook(bookId,emailId);
	}
	public List<Book> addReserve(String bookTitle,String authorName) {
		if(d.addReserve(bookTitle,authorName).size()==0) {
			return null;
		}
		else {
			return d.addReserve(bookTitle,authorName);
		}
	}
	public String currentTime() {
		long currentTime=System.currentTimeMillis();
		SimpleDateFormat si=new SimpleDateFormat("hh:mm:ss");
		Date dateObj=new Date(currentTime);
		return si.format(dateObj);
	}
	public String returnTime() {
		long currentTime=System.currentTimeMillis()+60000;
		SimpleDateFormat si=new SimpleDateFormat("hh:mm:ss");
		Date dateObj=new Date(currentTime);
		return si.format(dateObj);
	}
	
	public void addIssueBook(int bookId,String email) {
		String x=returnTime();
		String y=currentTime();
		d.addIssueBook(bookId,email,y,x);
	}
	public void updateMember(String emailId) {
		d.updateMember(emailId);
	}
	public void changeStatus(int bookId,boolean status) {
		d.changeStatus(bookId,status);
	}
	public boolean allowBook(String email) {
		return d.allowBook(email);
	}
	public String sendNotification(int bookId) {
		return d.sendNotification(bookId);
	}
	public long calFine(int bookId) {
		IssueBook book=d.calFine(bookId);
		String dueDate=book.getDueDate();
		String currentTime=currentTime();
		SimpleDateFormat si=new SimpleDateFormat("HH:mm:ss");
		Date d1=null;
		try {
			d1 = si.parse(dueDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date d2=null;
		try {
			d2 = si.parse(currentTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long diff=d2.getTime()-d1.getTime();
		if(diff>0) {
		long minutes=TimeUnit.MILLISECONDS.toMinutes(diff);
		return minutes*1;
		}
		return 0;
	}
	public void updateMember2(String email) {
		d.updateMember2(email);
	}
	public void deleteReserve(int bookId) {
		d.deleteReserve(bookId);
	}
	public void deleteIssueBook(int bookId) {
		d.deleteIssueBook(bookId);
	}
}
