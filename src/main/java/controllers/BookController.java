package controllers;

import entities.Books;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import repositories.BookRepository;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }
    @GetMapping("/{id}")
    public Books getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + id));
    }
    @PostMapping
    public Books createBook(@RequestBody Books book) {
        return bookRepository.save(book);
    }
    @PutMapping("/{id}")
    public Books updateBook(@PathVariable Long id, @RequestBody Books book) {
        Books existingBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + id));
        existingBook.setTitle(book.getTitle());
        return bookRepository.save(existingBook);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
