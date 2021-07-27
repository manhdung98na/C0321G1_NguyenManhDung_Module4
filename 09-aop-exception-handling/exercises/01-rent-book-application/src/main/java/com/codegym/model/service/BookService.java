package com.codegym.model.service;

import com.codegym.exception.BookException;
import com.codegym.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(String id);

    void rentBook(Book book) throws BookException;

    void returnBook(String id) throws BookException;
}
