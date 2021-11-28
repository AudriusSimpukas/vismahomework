package com.juniorjava.visma.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.juniorjava.visma.model.Book;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class BookFactory {

    private final Faker faker = new Faker();
    ObjectMapper mapper = new ObjectMapper();

    List<Book> books = new ArrayList<>();

    public Book createBook() throws IOException {
        Book book = new Book(faker.book().title(),
                faker.book().author(),
                faker.book().genre(),
                faker.nation().language(),
                faker.date().past(10000, TimeUnit.DAYS),
                faker.number().randomNumber(10, true),
                faker.idNumber().valid());

        books.add(book);

        mapper.writeValue(Paths.get("bookLibrary.json").toFile(), books);

        return book;
    }

    public List<Book> deleteBook(Long bookISBN) throws IOException {

        books.removeIf(book -> book.getIsbn().equals(bookISBN));

        mapper.writeValue(Paths.get("bookLibrary.json").toFile(), books);

        return books;

    }
}
