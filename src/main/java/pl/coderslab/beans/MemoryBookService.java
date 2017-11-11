package pl.coderslab.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.coderslab.entities.Book;

@Component
public class MemoryBookService {

	private List<Book> list;

	public void setList(List<Book> list) {
		this.list = list;
	}

	public MemoryBookService() {
		list = new ArrayList<>();
		list.add(new Book(1, "Ksiazka 1", "t1", "a1", "p1", 2345));
		list.add(new Book(2, "Ksiazka 2", "t2", "a2", "p2", 4532));
		list.add(new Book(3, "Ksiazka 3", "t3", "a3", "p3", 43256));
		list.add(new Book(444, "Ksiazka 4", "t4", "a4", "p4", 283745));
		list.add(new Book(5, "Ksionkszka 5", "Autor5", "publiszer 5", "typ 5", 432345));

	}

	
	
	public List<Book> getList() { // GET ALL BOOKS
		System.out.println("MBS - getList - success");
		return list;
	}

	public Book getBook(long id) { // GET BOOK WITH ID
		Book book = null;
		for (Book each : this.list) {
			if (each.getId() == id) {
				book = each;
				break;
			}
		}
		System.out.println("MBS - getBook - success");
		return book;
	}
	
	

	public void addNewBook(Book book) { // ADD BOOK
		boolean isThere = false;
		for (Book each : this.list) {
			if (each.getId() == book.getId()) {
				System.out.println("Cannot add. Book with id" + book.getId() + " already exists in the system");
				isThere = true;
				break;
			}
		}
		if (isThere == false) {

			ArrayList<Integer> idList = new ArrayList<>(); // set ID (delete when connected to DB
			int max = 0;
			for (Book each : this.list) {
				idList.add((int) each.getId());
			}
			for (int i = 0; i < idList.size(); i++) {
				if (idList.get(i) > max) {
					max = idList.get(i);
				}
			}
			book.setId(max + 1);
			list.add(book);
			System.out.println("MBS - addNewBoko - success");
		}
	}
	
	

	public void deleteBook(long id) {
		boolean isSucceded = false;
		int index = 0;
		for (Book each : this.list) {
			if (each.getId() == id) {
				list.remove(index);
				isSucceded = true;
				System.out.println("MBS - deleteBook - success");
				break;
			}
			index++;
		}
		if (isSucceded = false) {
			System.out.println("MBS - addNewBoko - fail");
		}
	}

	public void editBook(Book book, long id) {
		boolean isSucceded = false;
		for (Book each : this.list) {
			if (each.getId() == id) {
				each.setTitle(book.getTitle());
				each.setAuthor(book.getAuthor());
				each.setType(book.getType());
				each.setPublisher(book.getPublisher());
				each.setIsbn(book.getIsbn());
				isSucceded = true;
				break;
			}
		}
		if (isSucceded == false) {
			System.out.println("MBS - addNewBoko - fail");
		}
	}
}
