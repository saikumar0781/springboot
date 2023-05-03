package com.spring.Book.controller;

import java.util.*;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Book.entity.Book;
import com.spring.Book.service.BookService;

@Controller
public class AdminController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/admin")
	public String helloPage()
	{
		System.out.println("In admin Controller...");
		
		return "admin";
	}
	
	
	@RequestMapping("/admin/insert")
	public String insertBook()
	{
		System.out.println("In admin Controller...Adding the Book");
		
		return "adminbookinsert";
	}
	
	@GetMapping("/admin/showBooks")
	public ModelAndView adminShowBooks(Map<String, List<Book>> map) throws Exception{
		
		ModelAndView obj = new ModelAndView();
		try {
			List<Book> books = bookService.getAllBooks();
			System.out.println(books);
			map.put("book", books);
			
			obj.addObject("book", books);
			obj.setViewName("adminshowbooks");
			return obj;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return obj;	
	}
	
	
	@GetMapping("/admin/delete/{id}")
	public ModelAndView deleteById(@PathVariable("id") int bookId) throws Exception
	{
		System.out.println("In admin Controller...bookID..."+bookId);
		bookService.deletionById(bookId);
		System.out.println("In admin Controller...tryin to delete...");
		
		Map<String, List<Book>> map = new HashMap<>();
		
		ModelAndView obj = new ModelAndView();
		try {
			List<Book> books = bookService.getAllBooks();
			System.out.println(books);
			map.put("book", books);
			
			obj.addObject("book", books);
			obj.setViewName("adminshowbooks");
			return obj;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return obj;	
	}
	
	@PostMapping("/admin/insertbook")
	public String bookInsertion(@RequestParam String bookName,@RequestParam String authorName,@RequestParam String publication,@RequestParam long price)
	{
		System.out.println("In admin Controller...Adding the Book");
		
		Book book = new Book();
		book.setBookTitle(bookName);
		book.setBookAuthor(authorName);
		book.setBookPublication(publication);
		book.setPrice(price);

		
		System.out.println(book);
		
		 
		
		
		try {
			bookService.insertBook(book);
			System.out.println("Adding the Book details...");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Redirecting to Admin...");
		return "adminbookinsert";
	}
	
	@GetMapping("/admin/update/{id}")
	public ModelAndView updateById(@PathVariable("id") int bookId) 
	{
		ModelAndView obj = new ModelAndView();
		
		obj.addObject("bookId", bookId);
		obj.setViewName("adminbookupdate");
		
		return obj;
	}
	
	
	@PostMapping("/admin/update/finalupdate/{bookId}")
	public String bookUpdation(@PathVariable("bookId") int bookId, @RequestParam String title,@RequestParam String author,@RequestParam String publication,@RequestParam long price) throws Exception
	{
		try {
			Book newBook = new Book();
			newBook.setBookAuthor(author);
			newBook.setBookPublication(publication);
			newBook.setBookTitle(title);
			newBook.setPrice(price);
			bookService.updateBook(bookId, newBook);
			return "redirect:/admin/showBooks";	
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return "redirect:/admin/showBooks";
	}
	
	
	@GetMapping("/admin/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("newAdmin");
		session.invalidate();
		return "redirect:/hommie";
	}
	

}
