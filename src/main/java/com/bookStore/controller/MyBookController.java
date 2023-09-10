package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.model.MyBook;
import com.bookStore.service.MyBookService;

@RestController
public class MyBookController {
	
	@Autowired
	private MyBookService myBookService;
	
	@GetMapping("findBookById/{id}")
	public MyBook findById(@PathVariable("id") long id) {
		MyBook myBook = myBookService.getBookById(id);
		return myBook;
	}
	@DeleteMapping("deleteBook/{id}")
	public void deleteBookById(@PathVariable("id") long id) {
		myBookService.deleteBookById(id);
	}
}
