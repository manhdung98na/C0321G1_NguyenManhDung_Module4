package com.codegym.model.service;

import com.codegym.exception.BookException;
import com.codegym.model.entity.Book;
import com.codegym.model.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository repository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Book findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void rentBook(Book book) throws BookException {
        if (repository.existsById(book.getId())){
            if (book.getQuantityOfBook() <= 0) throw new BookException();
            book.setQuantityOfBook(book.getQuantityOfBook() - 1);
            repository.save(book);
        }else throw new BookException();
    }

    @Override
    public void returnBook(String id) throws BookException {
        Book book = repository.findById(id).orElse(null);
        if (book == null) throw new BookException();
        book.setQuantityOfBook(book.getQuantityOfBook()+1);
        repository.save(book);
    }
}
