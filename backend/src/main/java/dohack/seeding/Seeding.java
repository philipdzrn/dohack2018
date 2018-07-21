package dohack.seeding;

import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import dohack.like.service.UserLikesChallengeService;
import dohack.user.model.User;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class Seeding {
   @Autowired
   public UserService userService;
   @Autowired
   public ChallengeService challengeService;
   @Autowired
   public UserLikesChallengeService userLikesChallengeService;
   
   public Seeding() {
      // Create users
      User user = new User("", "", 0, "");
      
      // Create Challenges
      Challenge challenge = new Challenge();
      
      // Create likes
      
      // Save users
      
      // save Challenges
   }
   

   
}
