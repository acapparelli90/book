package it.book.dao.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import it.book.dao.entity.Book;
import it.book.dto.BookDto;

@Repository
public class BookDaoImpl implements BookRepository {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<BookDto> getAllBooks() {
		CriteriaBuilder criteria = em.getCriteriaBuilder();
		CriteriaQuery<BookDto> query = criteria.createQuery(BookDto.class);
		Root<Book> root = query.from(Book.class);
		query.select(criteria.construct(BookDto.class, root.get("titolo"), root.get("autore"), root.get("isbn"),
				root.get("img"), root.get("prezzo"), root.get("trama")));
		TypedQuery<BookDto> result = em.createQuery(query);
		return result.getResultList();
	}

	@Override
	@Transactional
	public BookDto save(BookDto book) {
		em.persist(modelMapper.map(book, Book.class));
		return book;

	}

	@Override
	@Transactional
	public void delete(int id) {
		Book book = em.find(Book.class, id);
		em.remove(book);

	}

	@Override
	public BookDto update(BookDto book) {
		em.merge(modelMapper.map(book, Book.class));
		return book;
	}
}
