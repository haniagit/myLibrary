package com.hania.library.controller;

import com.hania.library.model.Book;
import com.hania.library.model.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String addBook (@ModelAttribute Book book){
        bookDao.save(book);
        return "books";

    }
}
