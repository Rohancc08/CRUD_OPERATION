package com.javaguide.Spring_Boot_Backend.Controller;

import com.javaguide.Spring_Boot_Backend.Model.Books;
import com.javaguide.Spring_Boot_Backend.Service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    // Create a new book
    @PostMapping
    public Books createBook(@RequestBody Books book) {
        return booksService.saveOrUpdate(book);
    }

    // Retrieve all books ordered by creation time in descending order
    @GetMapping
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }


    // Retrieve a specific book by ID
    @GetMapping("/{bookid}")
    public Optional<Books> getBookById(@PathVariable("bookid") int bookid) {
        return booksService.getBooksById(bookid);
    }

    // Update a book
    @PutMapping("/{bookid}")
    public Books updateBook(@RequestBody Books book, @PathVariable("bookid") int bookid) {
        book.setBookid(bookid);
        return booksService.update(book);
    }

    // Delete a specific book by ID
    @DeleteMapping("/{bookid}")
    public void deleteBook(@PathVariable("bookid") int bookid) {
        booksService.delete(bookid);
    }
}
