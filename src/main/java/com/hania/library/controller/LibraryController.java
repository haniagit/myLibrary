package com.hania.library.controller;

import com.hania.library.model.Book;
import com.hania.library.model.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibraryController {

    @Autowired
    private BookDao bookDao;

    @GetMapping("/")
    public String home(ModelMap modelMap){
        modelMap.put("book", new Book());
        return "homePage";
    }

    @PostMapping("/add")
    public String addBook (@ModelAttribute Book book, ModelMap modelMap){
        bookDao.save(book);
        modelMap.put("books", bookDao.findAll());
        return "books";
    }

    @GetMapping("books")
    public String allBooks(ModelMap modelMap){
        modelMap.put("books", bookDao.findAll());
        return "books";
    }

    @GetMapping("book/{id}")
    public String getTask(@PathVariable Integer id, ModelMap modelMap){
        modelMap.put("book", bookDao.findById(id));
        return "show";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Book book){
        bookDao.save(book);
        return "redirect:/books";
    }

    @GetMapping("remove/{id}")
    public String remove(@ModelAttribute Book book){
        bookDao.deleteById(book.getId());
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String search(ModelMap modelMap, String q){
        modelMap.put("books", bookDao.searchBook(q));
        return "/books";
    }

}
