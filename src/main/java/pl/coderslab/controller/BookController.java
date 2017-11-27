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
import pl.coderslab.interfaces.IBookService;

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
	IBookService bookService;

	@RequestMapping("")
	public List<Book> showBooks() {
		return bookService.getList();
	}

	@RequestMapping("/get/{id}")
	@ResponseBody
	public Book getBook(@PathVariable("id") long id) {
		return bookService.getBook(id);
	}

	@PostMapping("")
	public void add(@RequestBody Book book) {
		System.out.println("POST request is in controller");
		bookService.addNewBook(book);
	}

	@PutMapping("/{id}")
	public void editBook(@RequestBody Book book, @PathVariable("id") long id) {
		System.out.println("PUT request is in controller");
		bookService.editBook(book, id);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable("id") long id) {
		bookService.deleteBook(id);
	}

}
