package dohack.challenge.repo;

import dohack.challenge.model.Challenge;
import dohack.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Integer> {

    List<Challenge> findByCreator(User creator);

}
