package com.visa.training.library.service;

import java.util.List;

import com.visa.training.library.domain.*;

public interface ChapterService {
	
	public int addNewChapter(Chapter c);
	public Chapter findById(int id);
	public List<Chapter> findAll();
	public void deleteChapter(int id);
	public void update(Chapter c);
	public void remove(int id);

}
