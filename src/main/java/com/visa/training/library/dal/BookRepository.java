package com.visa.training.library.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.visa.training.library.domain.Book;
import com.visa.training.library.domain.Chapter;

@Repository
public interface BookRepository  extends CrudRepository<Book, Integer> {
	
	public Book findById(int id);
	public List<Book> findAll();
	
}
