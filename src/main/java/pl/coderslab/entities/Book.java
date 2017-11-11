package pl.coderslab.entities;

public class Book {
	
	private long id;
	private String title;
	private String author;
	private String publisher;
	private String type;
	private long isbn;
	
	public Book(long id, String title, String author, String publisher, String type, long isbn) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.type = type;
		this.isbn = isbn;
	}
	
	public Book() {
	}
	
	
	public long getId() {
		return id;
	}
	public long getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getType() {
		return type;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", type="
				+ type + ", isbn=" + isbn + "]";
	}
}
