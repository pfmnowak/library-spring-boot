package pl.miknow.library.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.miknow.library.Manager.BookManager;
import pl.miknow.library.model.Book;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookApi {

    private BookManager bookManager;

    @Autowired
    public BookApi(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @GetMapping("/all")
    public Iterable<Book> getAll() {
        return bookManager.findAll();
    }

    @GetMapping
    public Optional<Book> getById(@RequestParam Long index) {
        return bookManager.findById(index);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookManager.save(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        return bookManager.save(book);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        bookManager.deleteById(id);
    }

}
