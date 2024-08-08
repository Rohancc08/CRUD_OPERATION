package com.javaguide.Spring_Boot_Backend.Service;

import com.javaguide.Spring_Boot_Backend.Model.Books;
import com.javaguide.Spring_Boot_Backend.Repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    // Retrieve all books ordered by creation time in descending order
    public List<Books> getAllBooks() {
        return booksRepository.findAllByOrderByCreatedAtDesc();
    }

    // Retrieve a specific book by ID
    public Optional<Books> getBooksById(int id) {
        return booksRepository.findById(id);
    }

    // Save or update a book
    public Books saveOrUpdate(Books book) {
        return booksRepository.save(book);
    }

    // Delete a specific book by ID
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    // Update a specific book (the book's ID must be set)
    public Books update(Books book) {
        return booksRepository.save(book);
    }
}
