package dohack.userAcceptsChallenge.model;

import dohack.challenge.model.Challenge;
import dohack.user.model.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "userAcceptsChallenge")
public class UserAcceptsChallenge {
   //region Attributes
   @Id
   @GeneratedValue
   private Integer id;
   
   @ManyToOne
   private User user;
   
   @ManyToOne
   private Challenge challenge;
   //endregion
   
   //region Constructors
   public UserAcceptsChallenge(User user, Challenge challenge) {
      this.user = user;
      this.challenge = challenge;
   }
   
   public UserAcceptsChallenge() {
   }
   //endregion
   
   //region Getter Setter
   public Integer getId() {
      return id;
   }
   
   public void setId(Integer id) {
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
