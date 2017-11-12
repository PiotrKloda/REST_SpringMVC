package pl.coderslab.interfaces;

import java.util.List;

import pl.coderslab.entities.Book;


public interface IBookService {

	List<Book> getList() ;
	
	Book getBook(long id);
	
	void addNewBook(Book book);
	
	void deleteBook(long id);
	
	void editBook(Book book, long id);
	
	
	
	
	
	
	
	
}
