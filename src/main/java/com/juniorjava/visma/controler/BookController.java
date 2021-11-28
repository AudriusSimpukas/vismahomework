package com.juniorjava.visma.controler;

import com.juniorjava.visma.model.Book;
import com.juniorjava.visma.utils.BookFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookFactory bookFactory;

    public BookController(BookFactory bookFactory) {
        this.bookFactory = bookFactory;
    }

    @GetMapping("/add")
    public ResponseEntity<Book> addNewBook() throws IOException {
        return ResponseEntity.ok(bookFactory.createBook());
    }

    @GetMapping("/delete")
    public ResponseEntity<List<Book>> deleteExistingBook(
            @RequestParam(name = "isbn") Long isbnNumber) throws IOException {
        return ResponseEntity.ok(bookFactory.deleteBook(isbnNumber));
    }
}
