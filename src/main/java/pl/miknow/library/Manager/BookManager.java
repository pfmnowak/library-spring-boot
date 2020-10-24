package pl.miknow.library.Manager;

import org.springframework.stereotype.Service;
import pl.miknow.library.dao.BookRepository;
import pl.miknow.library.model.Book;

import java.util.Optional;

@Service
public class BookManager {

    private BookRepository bookRepository;

    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
