package com.bookStore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.MyBookEntity;
import com.bookStore.model.MyBook;
import com.bookStore.repository.MyBookRepository;
import com.bookStore.service.MyBookService;

@Service
public class MyBookServiceImpl implements MyBookService{
	@Autowired
	private MyBookRepository myBookRepository;
	
	@Override
	public void saveToMyBook(MyBook myBook) {
		// TODO Auto-generated method stub
		MyBookEntity myBookEntity = new MyBookEntity();
		BeanUtils.copyProperties(myBook, myBookEntity);
		myBookRepository.save(myBookEntity);
	}

	@Override
	public List<MyBook> fetchAllMyBooks() {
		// TODO Auto-generated method stub
		List<MyBookEntity> myBookEntities = myBookRepository.findAll();
		List<MyBook> myBooks = myBookEntities.stream()
				.map(book -> new MyBook(
						book.getId(),book.getName(),book.getAuthor(),book.getPrice()))
				.collect(Collectors.toList());
		return myBooks;
	}

	@Override
	public MyBook getBookById(long id) {
		// TODO Auto-generated method stub
		MyBookEntity myBookEntity = myBookRepository.findById(id).get();
		MyBook myBook = new MyBook();
		BeanUtils.copyProperties(myBookEntity, myBook);
		return myBook;
	}

	@Override
	public void deleteBookById(long id) {
		// TODO Auto-generated method stub
		myBookRepository.deleteById(id);
	}

}
