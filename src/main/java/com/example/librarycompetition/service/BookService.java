package com.example.librarycompetition.service;

import com.example.librarycompetition.domain.Book;
import com.example.librarycompetition.dto.BookDTO;
import com.example.librarycompetition.exception.ListNotFoundElementException;
import com.example.librarycompetition.exception.ResourceNotFoundException;
import com.example.librarycompetition.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public BookDTO getOneBook(String bookId) {
        return BookDTO.from(bookRepository.findByBookId(bookId).orElseThrow(ResourceNotFoundException::new));
    }

    @Transactional
    public List<BookDTO> getAllBook() {
        List<Book> books = bookRepository.findAll();

        if (books.isEmpty()) {
            throw new ListNotFoundElementException();
        }

        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            bookDTOs.add(BookDTO.from(book));
        }

        return bookDTOs;
    }

    @Transactional
    public List<BookDTO> getBooksByBookTitle(String bookTitle) {
        List<Book> books = bookRepository.findBooksByBookTitle(bookTitle);

        if(books.isEmpty()) {
            throw new ListNotFoundElementException();
        }

        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            bookDTOs.add(BookDTO.from(book));
        }

        return bookDTOs;
    }

    @Transactional
    public List<BookDTO> getBooksByBookAuthor(String bookAuthor) {
        List<Book> books = bookRepository.findBooksByBookAuthor(bookAuthor);

        if(books.isEmpty()) {
            throw new ListNotFoundElementException();
        }

        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            bookDTOs.add(BookDTO.from(book));
        }

        return bookDTOs;
    }

    @Transactional
    public List<BookDTO> getBooksByBookDamage(Integer bookDamage) {
        List<Book> books = bookRepository.findBooksByBookDamage(bookDamage);

        if(books.isEmpty()) {
            throw new ListNotFoundElementException();
        }

        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            bookDTOs.add(BookDTO.from(book));
        }

        return bookDTOs;
    }

    @Transactional
    public List<BookDTO> getBooksByBookLabel(String bookLabel) {
        List<Book> books = bookRepository.findBooksByBookLabel(bookLabel);

        if(books.isEmpty()) {
            throw new ListNotFoundElementException();
        }

        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            bookDTOs.add(BookDTO.from(book));
        }

        return bookDTOs;
    }

    @Transactional
    public BookDTO createBook(BookDTO bookDTO) {
        return BookDTO.from(bookRepository.insert(bookDTO.toEntity()));
    }

    @Transactional
    public BookDTO updateBook(BookDTO bookDTO) {
        return BookDTO.from(bookRepository.save(bookDTO.toEntity()));
    }

    @Transactional
    public void deleteBook(String bookId) {
        bookRepository.deleteByBookId(bookId);
    }
}
