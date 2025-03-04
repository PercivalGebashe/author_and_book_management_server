package com.github.percivalgebashe.assignment_5_application2.service;

import com.github.percivalgebashe.assignment_5_application2.dto.BookDTO;
import com.github.percivalgebashe.assignment_5_application2.dto.BookFilterDTO;
import com.github.percivalgebashe.assignment_5_application2.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Page<BookDTO> findAll(Pageable pageable);

    BookDTO findById(String id);

    BookDTO findByTitle(String title);

    BookDTO findByIsbn(String isbn);

    BookDTO findByGenre(String genre);

    Page<BookDTO> findBookByFilter(BookFilterDTO filter, Pageable pageable);

    Book save(BookDTO book);

    List<BookDTO> saveAll(List<BookDTO> books);

    BookDTO updateBook(BookDTO bookDTO);

    List<BookDTO> updateBooks(List<BookDTO> bookDTOs);

    void deleteBook(String id);
}
