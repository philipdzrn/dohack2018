package dohack.user.model;

import dohack.challenge.model.Challenge;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    @Column
    private String name;

    @OneToMany
    List<Challenge> challenges;
}
