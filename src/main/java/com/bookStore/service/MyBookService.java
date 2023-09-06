package com.bookStore.service;

import java.util.List;

import com.bookStore.model.MyBook;

public interface MyBookService {

	void saveToMyBook(MyBook myBook);

	List<MyBook> fetchAllMyBooks();

}
