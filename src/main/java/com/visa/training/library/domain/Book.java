package com.visa.training.library.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Chapter> chapters = new ArrayList<Chapter>();
	
	
	
	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}

	@Column(name = "book_name")
	private String name;
	
	@Column(name = "book_author")
	private String author;
	
	@Column(name = "book_category")
	private String category;
	
	@Column(name = "book_releaseYear")
	private int year;

	public Book() {
		
	}
	
	public Book(String name, String author, String category, int year) {
		super();
		this.name = name;
		this.author = author;
		this.category = category;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", chapters=" + chapters + ", name=" + name + ", author=" + author + ", category="
				+ category + ", year=" + year + "]";
	}
	
	public void addChapter(Chapter chapter) {
		chapters.add(chapter);
		chapter.setBook(this);
	}
	
	public void removeChapter(Chapter chapter) {
		chapters.remove(chapter);
		chapter.setBook(null);
	}
	
		
	
}
