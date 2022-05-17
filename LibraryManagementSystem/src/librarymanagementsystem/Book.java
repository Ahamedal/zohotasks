package librarymanagementsystem;

public class Book {
 
	private String author;
	private String bookTitle;
	private String subject;
	private String publicationDate;
	private int uniqueIdNumber;
	private int rackNo;
	private boolean available=true;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public int getUniqueIdNumber() {
		return uniqueIdNumber;
	}
	public void setUniqueIdNumber(int uniqueIdNumber) {
		this.uniqueIdNumber = uniqueIdNumber;
	}
	public int getRackNo() {
		return rackNo;
	}
	public void setRackNo(int rackNo) {
		this.rackNo = rackNo;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return " [BookTitle=" + bookTitle + ", author=" + author + ", subject=" + subject + ", publicationDate="
				+ publicationDate + ", uniqueIdNumber=" + uniqueIdNumber + ", rackNo=" + rackNo + "]";
	}
	
	
}
