package librarymanagementsystem;

import java.util.Scanner;

public class Runner {
	public void addBook() {
		LibraryManagement objForLogic=new LibraryManagement();
		Book bookObj=new Book();
		bookObj.setAuthor("aa");
		bookObj.setBookTitle("Cp");
		
		bookObj.setPublicationDate("10:02:2000");
		bookObj.setSubject("Computer Programming");
		bookObj.setRackNo(1);
		objForLogic.addBook(bookObj);
		
		Book bookOb1=new Book();
		bookOb1.setAuthor("aa");
		bookOb1.setBookTitle("Cp");
		bookOb1.setPublicationDate("1:6:2002");
		bookOb1.setSubject("Computer Programming");
		bookOb1.setRackNo(1);
		objForLogic.addBook(bookOb1);
		
		Book bookObj2=new Book();
		bookObj2.setAuthor("aaaaa");
		bookObj2.setBookTitle("Poems");
		bookObj2.setPublicationDate("1:1:2000");
		bookObj2.setSubject("Tamil");
		bookObj2.setRackNo(1);
		objForLogic.addBook(bookObj2);
		
		Book bookObj3=new Book();
		bookObj3.setAuthor("mmmm");
		bookObj3.setBookTitle("Mathematics-1");
		bookObj3.setPublicationDate("22:9:2018");
		bookObj3.setSubject("Maths");
		bookObj3.setRackNo(2);
		objForLogic.addBook(bookObj3);
		

		Book bookObj4=new Book();
		bookObj4.setAuthor("ccccc");
		bookObj4.setBookTitle("Chemisty");
		bookObj4.setPublicationDate("11:10:2011");
		bookObj4.setSubject("Chemistry");
		bookObj4.setRackNo(2);
		objForLogic.addBook(bookObj4);
		
		Book bookObj7=new Book();
		bookObj7.setAuthor("ccccc");
		bookObj7.setBookTitle("Chemisty");
		bookObj7.setPublicationDate("22:1:2000");
		bookObj7.setSubject("Chemistry");
		bookObj7.setRackNo(2);
		objForLogic.addBook(bookObj7);
	    
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Runner runner=new Runner();
	LibraryManagement objForLogic=new LibraryManagement();
	boolean condition=true;
	while(condition) {
		System.out.println("1.create table 2.insert values 3.Search Books 4. CheckOut Book ");
		int sel=sc.nextInt();
		sc.nextLine();
		switch(sel) {
		case 1:
			objForLogic.createTable();
			break;
			
		case 2:
			runner.addBook();
			break;
			
		case 3:
			System.out.println("1-Search by Author name 2-Search by title 3-Search by subject 4-Search by PublicationDate");
			int sel2=sc.nextInt();
			sc.nextLine();
			switch(sel2) {
			case 1:
				System.out.println("Enter Author name");
				String name=sc.nextLine();
			    System.out.println( objForLogic.searchByAuthor(name));
				break;
				
			case 2:
				System.out.println("Enter book title name");
				String bookTitle=sc.nextLine();
			    System.out.println( objForLogic.searchByTitle(bookTitle));
				break;
				
			case 3:
				System.out.println("Enter book title name");
				String sub=sc.nextLine();
				System.out.println(objForLogic.searchBySubject(sub));
				break;
				
			
				
			}
			break;
		case 4:
			System.out.println("1.Existing Customer 2.New Customer");
			int sel4=sc.nextInt();
			sc.nextLine();
			switch(sel4) {
			case 1:
				System.out.println("Enter your email Id");
				String email=sc.nextLine();
				System.out.println("Enter book name");
				String bookTitle1=sc.nextLine();
				System.out.println("Enter Author name");
				String authorName1=sc.nextLine();
				if(objForLogic.bookCheckOut(bookTitle1,authorName1)==null) {
					System.out.println("This book is not available");
					//objForLogic.reserveBook(bookTitle,authorName);
				}
				else {
					System.out.println(objForLogic.bookCheckOut(bookTitle1,authorName1));
					objForLogic.updateMember(email);
				}

				break;
			case 2:
			
			System.out.println("Enter your name");
			String name=sc.nextLine();
			System.out.println("Enter your email Id");
			String emailId=sc.nextLine();
			System.out.println("Enter your mobile No");
			long mobileNumber=sc.nextLong();
			sc.nextLine();
			System.out.println("Enter book name");
			String bookTitle=sc.nextLine();
			System.out.println("Enter Author name");
			String authorName=sc.nextLine();
			objForLogic.addMember(authorName, emailId, mobileNumber);
			if(objForLogic.bookCheckOut(bookTitle,authorName)==null) {
				System.out.println("This book is not available");
				//objForLogic.reserveBook(bookTitle,authorName);
			}
			else {
				Book bookObj=objForLogic.bookCheckOut(bookTitle,authorName);
				
			    System.out.println(bookObj);
			    int bookId=bookObj.getUniqueIdNumber();
			    objForLogic.addIssueBook(bookId,emailId);
			    objForLogic.changeStatus(bookId);
				objForLogic.updateMember(emailId);
			}
			}
			break;
			
		
			
			}
		}
	

}
}
