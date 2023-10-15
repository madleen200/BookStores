package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="Users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="User ID")
    private long id;

////////////////////////////////////////////////////////////
    @Column(name="User Name")
    private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="Password")
    private String password;
////////////////////////////////////////////////////////////
@Column(name="User Role")
private String role;
////////////////////////////////////////////////////////////
public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @ManyToMany
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_name"))
    private Set<Authority> authorities;
}
