package com.visa.training.library.web;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visa.training.library.domain.Book;
import com.visa.training.library.domain.Chapter;
import com.visa.training.library.service.BookService;

@RestController
public class BookRestController {
        
    @Autowired
    BookService service;
    
    @RequestMapping(value="/api/books",method=RequestMethod.GET)
    public List<Book> getAll(){
   	
        return service.findAll();
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/api/books/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id")int id) {
        
        Book b = service.findById(id);
        
        if(b != null) {
            return new ResponseEntity<Book>(b, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
         
    }
    
    @RequestMapping(value="/api/books",method=RequestMethod.POST)
    public ResponseEntity createBook(@RequestBody Book toBeCreated) {
        
        try {
            int id = service.addNewBook(toBeCreated);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/api/books/"+id));
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        
    }
    
    @RequestMapping(method=RequestMethod.PUT,value="/api/books/{id}")
    public ResponseEntity<Book> updateExisting(@RequestBody Book b,@PathVariable("id")int id) {
        Book fromDB = service.findById(id);
        if(fromDB == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        fromDB.setName(b.getName());
       
        service.update(b);
        return new ResponseEntity<Book>(fromDB,HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.DELETE,value="/api/books/{id}")
    public ResponseEntity<Book> remove(@PathVariable("id")int id){
        Book fromDB = service.findById(id);
        if(fromDB == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.remove(id);
        return new ResponseEntity<Book>(fromDB,HttpStatus.OK);
    }

}