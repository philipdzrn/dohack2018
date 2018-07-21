package dohack.challenge.repo;

import dohack.challenge.model.Challenge;
import org.springframework.data.repository.CrudRepository;

public interface ChallengeRepository extends CrudRepository<Challenge, Integer> {
}
