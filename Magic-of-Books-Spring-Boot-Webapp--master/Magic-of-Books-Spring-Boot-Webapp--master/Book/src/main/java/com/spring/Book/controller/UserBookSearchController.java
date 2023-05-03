package com.spring.Book.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Book.entity.Book;
import com.spring.Book.service.BookService;

@Controller
public class UserBookSearchController {
	
	@Autowired
	BookService bookService;
	
//	@GetMapping("/userbooklookbytitle/{input}")
//	public ModelAndView UserBookSearchByTitle(@PathVariable("input") String input, HttpSession session)
//	{
//		ModelAndView obj = new ModelAndView();
//		
//		List<Book> books = new ArrayList<>();
//		try {
//			 
//			 
//				books = bookService.findByBookTitleIgnoreCase(input);
//				obj.addObject("books",books);
//				obj.setViewName("userbooksearchresult");
//				return obj;	
//		}
//		
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//		obj.setViewName("userbooksearch");
//		return obj;
//	}
//	
//	@GetMapping("/userbooklookbyauthor/{input}")
//	
//	public ModelAndView UserBookSearchByAuthor(@PathVariable("input") String input, HttpSession session)
//	{
//		
//		System.out.println("here in the Author search controller...Author: "+input);
//		ModelAndView obj = new ModelAndView();
//		
//		List<Book> books = new ArrayList<>();
//		
//		try {
//			 
//				books = bookService.findByBookAuthorIgnoreCase(input);
//				obj.addObject("books",books);
//				obj.setViewName("userbooksearchresult");
//				return obj;
//			}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//		obj.setViewName("userbooksearch");
//		
//		return obj;
//		
//	}
//	
//	@GetMapping("/userbooklookbypublication/{input}")
//	public ModelAndView UserBookSearchByPublication(@PathVariable("input") String input, HttpSession session)
//	{
//		ModelAndView obj = new ModelAndView();
//		
//		List<Book> books = new ArrayList<>();
//		
//		try {
//			 
//				books = bookService.findByBookPublicationIgnoreCase(input);
//				obj.addObject("books",books);
//				obj.setViewName("userbooksearchresult");
//				return obj;
//			}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//		obj.setViewName("userbooksearch");
//		
//		return obj;
//		
//	}
//	
//	@GetMapping("/userbooklookbyprice/{input}")
//	public ModelAndView UserBookSearchByPrice(@PathVariable("input") String input, HttpSession session)
//	{
//		ModelAndView obj = new ModelAndView();
//		
//		List<Book> books = new ArrayList<>();
//		
//		try {
//			 
//				books = bookService.findByPriceLessThanEqual(input);
//				obj.addObject("books",books);
//				obj.setViewName("userbooksearchresult");
//				return obj;
//			}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//		obj.setViewName("userbooksearch");
//		
//		return obj;
//		
//	}
	
	@PostMapping("/userbooklook")
	public ModelAndView finalBookSearch(@RequestParam String select, @RequestParam String input)
	{
		ModelAndView obj = new ModelAndView();
		
		List<Book> books = new ArrayList<>();
		
		try {
			
			if(select.equals("Price"))
			{
				books = bookService.findByPriceLessThanEqual(Long.parseLong(input));
				obj.addObject("books",books);
				obj.setViewName("userbooksearchresult");
				return obj;
			}
			
			else if(select.equals("Title"))
			{
				books = bookService.findByBookTitleIgnoreCase(input);
				obj.addObject("books",books);
				obj.setViewName("userbooksearchresult");
				return obj;	
			}
			else if(select.equals("Author"))
			{
				System.out.println("here in the Author search controller...Author: "+input);
				books = bookService.findByBookAuthorIgnoreCase(input);
				obj.addObject("books",books);
				obj.setViewName("userbooksearchresult");
				return obj;
			}
			else if(select.equals("Publication"))
			{
				books = bookService.findByBookPublicationIgnoreCase(input);
				obj.addObject("books",books);
				obj.setViewName("userbooksearchresult");
				return obj;
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		obj.setViewName("userbooksearch");
		
		return obj;
	}
	

}
