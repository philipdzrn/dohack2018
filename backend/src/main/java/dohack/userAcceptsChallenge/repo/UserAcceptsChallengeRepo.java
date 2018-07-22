package dohack.userAcceptsChallenge.repo;


import dohack.challenge.model.Challenge;
import dohack.like.model.UserLikesChallenge;
import dohack.user.model.User;
import dohack.userAcceptsChallenge.model.UserAcceptsChallenge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAcceptsChallengeRepo extends CrudRepository<UserAcceptsChallenge, Integer> {
   
   List<User> findByChallenge(Challenge challenge);
   List<Challenge> findByUser(User user);
   void deleteByChallengeAndUser(Challenge challenge, User user);
}
