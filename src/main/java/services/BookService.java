package services;

import entities.Books;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BookRepository;
import java.util.List;
@Service
public class BookService {
@Autowired
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Books> findAll() {
        return bookRepository.findAll();
    }
    public Books findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + id));
    }
    public Books save(Books book) {
        return bookRepository.save(book);
    }
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}