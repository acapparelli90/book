package it.book.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 
import it.book.dto.BookDto; 
import it.book.service.BookService; 

@RestController
@RequestMapping(value = "")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<BookDto>> getAllUsers() {
		return new ResponseEntity<List<BookDto>>(bookService.getAllBooks(), HttpStatus.OK);
	}

	@PostMapping(value = "/newBook")
	public BookDto insertUser(@RequestBody BookDto book) {
		return bookService.save(book);
	}

	@DeleteMapping(value = "/{id}")
	public BookDto deleteBook(@PathVariable("id") int id) {
		return bookService.delete(id);
	}

	@PutMapping(value = "edit/{id}")
	public BookDto updateBook(@PathVariable("id") int id, @RequestBody BookDto book) {
		return bookService.update(book);
	}

}
