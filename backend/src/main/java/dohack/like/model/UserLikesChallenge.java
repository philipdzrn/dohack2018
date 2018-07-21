package dohack.like.model;

import dohack.challenge.model.Challenge;
import dohack.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "userLikesChallenge")
public class UserLikesChallenge {
    
    //region Attributes
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;
    //endregion
    
    //region Constructors
    public UserLikesChallenge(User user, Challenge challenge) {
        this.user = user;
        this.challenge = challenge;
    }
    
    public UserLikesChallenge() {
    }
    //endregion
    
    //region Getter Setter
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Challenge getChallenge() {
        return challenge;
    }
    
    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
    //endregion
}
