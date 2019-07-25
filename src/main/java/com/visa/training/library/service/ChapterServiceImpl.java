package com.visa.training.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.library.dal.ChapterRepository;
import com.visa.training.library.domain.Chapter;

@Service
public class ChapterServiceImpl implements ChapterService {

	ChapterRepository dao;
	
	@Autowired
    public void setDao(ChapterRepository dao) {
        this.dao = dao;
    }
	
	@Override
	public int addNewChapter(Chapter c) {
		int id = 0;
		try {
			Chapter created = dao.save(c);
			id = created.getId();
			return id;
		}catch(Exception e){
			throw e;
		}
	}

	@Override
	public Chapter findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Chapter> findAll() {
		return dao.findAll(); 
	}

	@Override
	public void deleteChapter(int id) {
		Chapter c = dao.findById(id);
		try {
			dao.deleteById(id);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Chapter c) {
		dao.save(c);
	}

	@Override
	public void remove(int id) {
        dao.deleteById(id);

	}

}
