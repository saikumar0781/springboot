package com.spring.Book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Book.entity.Book;
import com.spring.Book.service.BookService;

@Controller
public class AdminBookSearchController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("admin/adminbooksearchhome")
	public String bookSearchPage()
	{
		return "adminbooksearch";
	}

	
	@PostMapping("admin/adminbooklook")
	public ModelAndView finalBookSearch(@RequestParam String select, @RequestParam String input)
	{
		ModelAndView obj = new ModelAndView();
		
		List<Book> books = new ArrayList<>();
		
		try {
			
			if(select.equals("BookId"))
			{
				Book newBook = bookService.findByBookId(Integer.parseInt(input));
				books.add(newBook);
				obj.addObject("books",books);
				obj.setViewName("adminbooksearchresult");
				return obj;
			}
			
			 
			else if(select.equals("Author"))
			{
				System.out.println("here in the Author search controller...Author: "+input);
				books = bookService.findByBookAuthorIgnoreCase(input);
				obj.addObject("books",books);
				obj.setViewName("adminbooksearchresult");
				return obj;
			}
			 
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		obj.setViewName("adminbooksearch");
		
		return obj;
	}

}
