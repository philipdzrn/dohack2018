package dohack.like.service;

import dohack.challenge.model.Challenge;
import dohack.like.repo.UserLikesChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserLikesChallengeService {

    @Autowired
    private UserLikesChallengeRepository userLikesChallengeRepository;
    
    /**
     * Return how many users have liked the challenge
     * @param challenge
     * @return
     */
    public int getLikesByChallenge(Challenge challenge){
        return this.userLikesChallengeRepository.findByChallenge(challenge).size();
    }
}
