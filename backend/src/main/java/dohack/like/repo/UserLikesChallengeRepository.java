package dohack.like.repo;

import dohack.challenge.model.Challenge;
import dohack.like.model.UserLikesChallenge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserLikesChallengeRepository extends CrudRepository<UserLikesChallenge, Integer> {
   
   List<UserLikesChallenge> findByChallenge(Challenge challenge);
}
