package com.spring.Book.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.Book.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query(
			  value = "SELECT * FROM Book ORDER BY price",
			  nativeQuery = true)
	List<Book> getAllSortedBooks();

	List<Book> findByBookAuthorIgnoreCase(String input);

	List<Book> findByBookPublicationIgnoreCase(String input);

	List<Book> findByBookTitleIgnoreCase(String input);

	List<Book> findByPriceLessThanEqual(long input);

}
