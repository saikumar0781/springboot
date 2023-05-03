package com.spring.Book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserSearchController {
	
	@RequestMapping("/usersearchhome")
	public String bookSearchPage()
	{
		return "userbooksearch";
	}

}
