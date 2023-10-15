package entities;

import jakarta.persistence.*;

import java.awt.print.Book;
import java.util.List;

@Entity
@Table(name="Stores")
public class Stores {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Store ID")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name="Store Name")
    String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   @Column(name="Store Location")
String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @OneToMany(mappedBy = "stores")
    private List<Books> books;
}
