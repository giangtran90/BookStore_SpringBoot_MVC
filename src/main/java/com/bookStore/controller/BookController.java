package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.model.Book;
import com.bookStore.model.MyBook;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookService myBookService;

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
	
	@GetMapping("/my_books")
	public ModelAndView myBooks() {
		ModelAndView modelAndView = new ModelAndView("/myBooks");
		List<MyBook> myBooks = myBookService.fetchAllMyBooks();
		modelAndView.addObject("myBooks", myBooks);
		return modelAndView;
	}
	
	@RequestMapping("/my_list/{id}")
	public String addToMyBooks(@PathVariable(value = "id") Long id) {
		Book book = bookService.fetchBookById(id);
		MyBook myBook = new MyBook(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
		myBookService.saveToMyBook(myBook);
		return "redirect:/my_books";
	}
	
	@GetMapping("/edit_book/{id}")
	public ModelAndView getBookById(@PathVariable(value = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("/bookEdit");
		Book book = bookService.fetchBookById(id);
		modelAndView.addObject("book", book);
		return modelAndView;
		
	}
}
