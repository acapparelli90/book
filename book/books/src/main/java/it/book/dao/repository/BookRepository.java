package it.book.dao.repository;

import java.util.List; 
import it.book.dto.BookDto;

public interface BookRepository {
	
	public List<BookDto> getAllBooks();

	public BookDto save(BookDto book);

	public BookDto delete(int id);

	public BookDto update(BookDto book);

}
