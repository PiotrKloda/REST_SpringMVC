package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.beans.MemoryBookService;
import pl.coderslab.entities.Book;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "{hello: World}";		
	}
	
	@RequestMapping("/helloBook")
	public Book helloBook() {
		return new Book(123432, "tytuuul", "ałtor", "publiszer", "typyta", 12342354);
	}
	
	@Autowired
	MemoryBookService mbs;
	
	//get All Books
	@RequestMapping("") 
	public List<Book> showBooks() {
		return mbs.getList();
	}
	
	@RequestMapping("/get/{id}")
	@ResponseBody
	public Book getBook(@PathVariable("id") long id) {
		return mbs.getBook(id);
	}
	

	@PostMapping("")
    public void add(@RequestBody Book book) {
		System.out.println("POST request is in controller");
		mbs.addNewBook(book);
    }
	
	
	@PutMapping("/{id}")
	public void editBook(@RequestBody Book book, @PathVariable("id") long id ) {
		System.out.println("PUT request is in controller");
		mbs.editBook(book, id);
	}
	
	@DeleteMapping("/{id}")
	public void remove( @PathVariable("id") long id ) {
		mbs.deleteBook(id);
	}
	
}
