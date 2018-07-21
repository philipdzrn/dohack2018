package dohack.user.model;

import dohack.challenge.model.Challenge;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    @Column
    private String name;

     @Basic
     @Column
     private String password;

    @OneToMany
    List<Challenge> challenges;
}
