package dohack.like.model;

import dohack.challenge.model.Challenge;
import dohack.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "userLikesChallenge")
public class UserLikesChallenge {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;

}
