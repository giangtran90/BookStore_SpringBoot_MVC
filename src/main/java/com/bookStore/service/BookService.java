package com.bookStore.service;

import java.util.List;

import com.bookStore.model.Book;

public interface BookService {

	void addBook(Book book);

	List<Book> getAllBook();

}
