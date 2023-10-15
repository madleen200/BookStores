package repositories;

import entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
}
