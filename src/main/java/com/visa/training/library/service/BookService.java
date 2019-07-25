package com.visa.training.library.service;

import java.util.List;

import com.visa.training.library.domain.*;

public interface BookService {
	
	public int addNewBook(Book b);
	public Book findById(int id);
	public List<Book> findAll();
	public void deleteBook(int id);
	public void update(Book b);
	public void remove(int id);

}
