package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class BookController {

	@Controller
	@ResponseBody
	public class HelloController {
		@RequestMapping("/hello")
	    public String hello(@RequestParam(name = "firstname") String firstName,
	            @RequestParam(name = "location") String location) {
	        return "Hello " + firstName + " from the " + location + " :-)))";
	    }
	}
}
