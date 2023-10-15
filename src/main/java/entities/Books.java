package entities;

import jakarta.persistence.*;

import java.awt.print.Book;
import java.util.List;

@Entity
@Table(name="Books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Authority author;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Stores getStore() {
        return store;
    }

    public void setStore(Stores store) {
        this.store = store;
    }

    public Authority getAuthor() {
        return author;
    }

    public void setAuthor(Authority author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Stores store;

}

