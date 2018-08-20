package com.hania.library.model;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface BookDao extends CrudRepository<Book, Integer> {

    public default List<Book> searchBook(String q){
        List<Book> searchedBooks = new ArrayList<>();
        for(Book book : findAll()){
            if(book.getAuthor().contains(q) || book.getTitle().contains(q)){
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

}
