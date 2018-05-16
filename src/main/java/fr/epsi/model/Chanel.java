package fr.epsi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "chanel")
public class Chanel implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private boolean status;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(nullable = true)
    private List<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

