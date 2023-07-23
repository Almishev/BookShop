package com.store.book.book.repository;


import com.store.book.book.model.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList,Integer> {
}
