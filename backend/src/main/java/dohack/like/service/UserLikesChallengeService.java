package dohack.like.service;

import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import dohack.like.model.UserLikesChallenge;
import dohack.like.repo.UserLikesChallengeRepository;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserLikesChallengeService {

    @Autowired
    private UserLikesChallengeRepository userLikesChallengeRepository;

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private UserService userService;
    
    /**
     * Return how many users have liked the challenge
     * @param challenge
     * @return
     */
    public int getLikesByChallenge(Challenge challenge){
        return this.userLikesChallengeRepository.findByChallenge(challenge).size();
    }

    public UserLikesChallenge addUserLikesChallenge( Integer userId, Integer challengeId ) {
        UserLikesChallenge userLikesChallenge = new UserLikesChallenge();
        userLikesChallenge.setChallenge(challengeService.getChallenge(challengeId));
        userLikesChallenge.setUser(userService.getUser(userId));
        return userLikesChallengeRepository.save(userLikesChallenge);
    }
}
