package com.store.book.book.service;


import com.store.book.book.model.MyBookList;
import com.store.book.book.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MyBookListService {

    @Autowired
    private MyBookRepository mybook;

    public void saveMyBooks(MyBookList book) {
        mybook.save(book);
    }

    public List<MyBookList> getAllMyBooks(){
        return mybook.findAll();
    }

    public void deleteById(int id) {
        mybook.deleteById(id);
    }
}




