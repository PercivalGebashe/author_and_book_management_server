package com.github.percivalgebashe.assignment_5_application2.service;

import com.github.percivalgebashe.assignment_5_application2.dto.BookDTO;
import com.github.percivalgebashe.assignment_5_application2.dto.BookFilterDTO;
import com.github.percivalgebashe.assignment_5_application2.entity.Book;
import com.github.percivalgebashe.assignment_5_application2.exception.ResourceNotFoundException;
import com.github.percivalgebashe.assignment_5_application2.repository.BookRepository;
import com.github.percivalgebashe.assignment_5_application2.specification.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Page<Book> findBookByFilter(BookFilterDTO filter, Pageable pageable) {
        Specification<Book> bookSpecification = BookSpecification.filterBooks(filter);
        return bookRepository.findAll(bookSpecification, pageable);
    }

    public Book save(BookDTO book) {
        if(null != book){
            return bookRepository.saveAndFlush(book.toBookEntity());
        }
        return null;
    }

    public Book updateBook(BookDTO bookDTO) {
        // Check if book exists by ID
        Optional<Book> existingBook = bookRepository.findById(bookDTO.getBook_id());
        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();
            // Update the fields of the existing book
            // bookDTO -> Update bookToUpdate
            return bookRepository.saveAndFlush(bookToUpdate);  // Ensure the entity is persisted
        } else {
            // Handle the case where book is not found
            throw new ResourceNotFoundException("Book with id " + bookDTO.getBook_id() + " not found");
        }
    }
}
