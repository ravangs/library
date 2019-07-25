package com.visa.training.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.library.dal.BookRepository;
import com.visa.training.library.domain.Book;

@Service
public class BookServiceImpl implements BookService {

	BookRepository dao;
	
	@Autowired
    public void setDao(BookRepository dao) {
        this.dao = dao;
    }
	
	@Override
	public int addNewBook(Book b) {
		int id = 0;
		try {
			Book created = dao.save(b);
			id = created.getId();
			return id;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public Book findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Book> findAll() {
		return dao.findAll(); 
	}

	@Override
	public void deleteBook(int id) {
		Book b = dao.findById(id);
		try {
			dao.deleteById(id);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Book b) {
		dao.save(b);
	}

	@Override
	public void remove(int id) {
        dao.deleteById(id);

	}

}
