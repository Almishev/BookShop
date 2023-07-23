package com.store.book.book.controller;

import com.store.book.book.model.Book;
import com.store.book.book.model.MyBookList;
import com.store.book.book.service.BookService;
import com.store.book.book.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookService;



    @GetMapping("/")
    public String home(){
        return "home";
    }


    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView  getAllBooks(){
      List<Book> list= service.getAllBook();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookList");
        modelAndView.addObject("book",list);

        return modelAndView;
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model)
    {
        List<MyBookList>list=myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/available_books";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b=service.getBookById(id);
        MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model) {
        Book b=service.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
}
