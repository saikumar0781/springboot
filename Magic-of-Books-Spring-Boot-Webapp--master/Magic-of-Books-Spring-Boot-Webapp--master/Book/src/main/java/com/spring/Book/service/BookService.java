package com.spring.Book.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.Book.entity.Book;
import com.spring.Book.repository.BookRepository;
@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	public List<Book> getAllBooks()
	{
		return bookRepo.findAll();
	}
	
	
	public void insertBook(Book book) throws Exception
	{
		try {
			bookRepo.save(book);
			System.out.println("Done with saving Book...");
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void deletionById(int bookId)
	{
				
		bookRepo.deleteById(bookId);
	}
	
	
	public Book findByBookId(int bookId) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			Book book = bookRepo.findById(bookId).get();
			return book;
		}
		catch(Exception e) {
			throw new Exception("Book with this ID does not exist...");
		}
		 
	}


	public Book getBookById(int bookId) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			Book book = bookRepo.getById(bookId);
			return book;
		}
		catch(Exception e) {
			throw new Exception("Book with this ID does not exist...");
		}
		 
	}


	public List<Book> getAllSortedBooks() throws Exception{
		// TODO Auto-generated method stub
		try {
			List<Book> books = bookRepo.getAllSortedBooks();
			return books;
		}
		catch(Exception e)
		{
			throw new Exception("Books NOT available...");
		}
	}


	public List<Book> findByBookAuthorIgnoreCase(String input) throws Exception{
		// TODO Auto-generated method stub
		
		try {
			return bookRepo.findByBookAuthorIgnoreCase(input);			
		}
		catch(Exception e)
		{
			throw new Exception("Book Not available...");
		}
		
	}


	public List<Book> findByBookPublicationIgnoreCase(String input) throws Exception {
		// TODO Auto-generated method stub
		try {
			return bookRepo.findByBookPublicationIgnoreCase(input);			
		}
		catch(Exception e)
		{
			throw new Exception("Book Not available...");
		}
		
	}


	public List<Book> findByBookTitleIgnoreCase(String input) throws Exception {
		// TODO Auto-generated method stub
		try {
			return bookRepo.findByBookTitleIgnoreCase(input);			
		}
		catch(Exception e)
		{
			throw new Exception("Book Not available...");
		}
	}


	public List<Book> findByPriceLessThanEqual(long input) throws Exception{
		// TODO Auto-generated method stub
		try {
			return bookRepo.findByPriceLessThanEqual(input);			
		}
		catch(Exception e)
		{
			throw new Exception("Book Not available...");
		}
	}
	
	
	
	public void updateBook(int bookId, Book newBook) throws Exception{
		// TODO Auto-generated method stub
		
		try {
			Book bookDb = bookRepo.findById(bookId).get();
			
			if(Objects.nonNull(newBook.getBookAuthor()) && !"".equalsIgnoreCase(newBook.getBookAuthor()))
			{
				bookDb.setBookAuthor(newBook.getBookAuthor());			
			}
			
			if(Objects.nonNull(newBook.getBookPublication()) && !"".equalsIgnoreCase(newBook.getBookPublication()))
			{
				bookDb.setBookPublication(newBook.getBookPublication());
				 
			}
			
			if(Objects.nonNull(newBook.getBookTitle()) && !"".equalsIgnoreCase(newBook.getBookTitle()))
			{
				bookDb.setBookTitle(newBook.getBookTitle());
			}
			
			if(Objects.nonNull(newBook.getPrice()))
			{
				bookDb.setPrice(newBook.getPrice());
			}
			
			   bookRepo.save(bookDb);
		}
		
		catch(Exception e) {
			throw new Exception("Book Not available...");	
		}
		
	}

}
