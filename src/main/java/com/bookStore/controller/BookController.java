package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.model.Book;
import com.bookStore.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		ModelAndView modelAndView = new ModelAndView("/bookList");
		List<Book> books = bookService.getAllBook();
		modelAndView.addObject("books", books);
		return modelAndView;
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		bookService.addBook(book);
		return "redirect:/available_books";
	}
}
