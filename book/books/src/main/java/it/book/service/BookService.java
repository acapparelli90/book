package it.book.service;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import it.book.dao.repository.BookRepository;
import it.book.dto.BookDto;

@Service
public class BookService implements BookServiceInterface {

	@Autowired
	private BookRepository dao;

	@Override
	public List<BookDto> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public BookDto save(BookDto book) {
		return dao.save(book);
	}

	@Override
	public BookDto delete(int id) {
		return dao.delete(id);

	}

	@Override
	public BookDto update(BookDto book) {
		return dao.update(book);
	}

}
