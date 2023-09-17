package com.bookStore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		List<BookEntity> bookEntities = bookRepository.findAll();
		List<Book> books = bookEntities.stream()
				.map(book -> new Book(
						book.getId(),book.getName(),book.getAuthor(),book.getPrice()))
				.collect(Collectors.toList());
		return books;
	}

	@Override
	public Book fetchBookById(Long id) {
		// TODO Auto-generated method stub
		BookEntity bookEntity = bookRepository.findById(id).get();
		Book book = new Book();
		BeanUtils.copyProperties(bookEntity, book);
		return book;
	}

	@Override
	public void updateBook(Long id, Book book) {
		// TODO Auto-generated method stub
		BookEntity bookEntity = bookRepository.findById(id).get();
		bookEntity.setName(book.getName());
		bookEntity.setAuthor(book.getAuthor());
		bookEntity.setPrice(book.getPrice());
		bookRepository.save(bookEntity);
	}

	@Override
	public void deleteBookById(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> findAllByName(String keyword) {
		// TODO Auto-generated method stub
		List<BookEntity> bookEntities = bookRepository.findAllByName(keyword);
		List<Book> books = bookEntities.stream()
				.map(b -> new Book(
						b.getId(),b.getName(),b.getAuthor(),b.getPrice()))
				.collect(Collectors.toList());
		return books;
	}
}
