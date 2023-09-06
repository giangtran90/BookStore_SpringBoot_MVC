package com.bookStore.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.BookEntity;
import com.bookStore.model.Book;
import com.bookStore.repository.BookRepository;
import com.bookStore.service.BookService;

@Service
public class BookServiceIpml implements BookService{
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		BookEntity bookEntity = new BookEntity();
		BeanUtils.copyProperties(book, bookEntity);
		bookRepository.save(bookEntity);
	}

}
