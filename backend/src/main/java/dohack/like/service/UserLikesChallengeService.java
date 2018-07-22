package dohack.like.service;

import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import dohack.like.dto.LikeByChallengeDTO;
import dohack.like.model.UserLikesChallenge;
import dohack.like.repo.UserLikesChallengeRepository;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
     * @param
     * @return
     */
    public List<UserLikesChallenge> getLikesByChallenge(Integer challengeId){
        Challenge challenge = challengeService.getChallenge(challengeId);
        return this.userLikesChallengeRepository.findByChallenge(challenge);
    }

    public LikeByChallengeDTO getLikeCountByChallengeId(Integer userId, Integer challengeId) {
        List<UserLikesChallenge> likesByChallenge = getLikesByChallenge(challengeId);

        LikeByChallengeDTO likeByChallengeDTO = new LikeByChallengeDTO();
        likeByChallengeDTO.setLikeCount(likesByChallenge.size());

        if(likesByChallenge.stream().anyMatch(like -> like.getUser().getId().equals(userId))) {
            likeByChallengeDTO.setCurrentUserLikedChallenge(true);
        }

        return likeByChallengeDTO;

    }

    public UserLikesChallenge addUserLikesChallenge( Integer userId, Integer challengeId ) {
        UserLikesChallenge userLikesChallenge = new UserLikesChallenge();
        userLikesChallenge.setChallenge(challengeService.getChallenge(challengeId));
        userLikesChallenge.setUser(userService.getUser(userId));
        if( userLikesChallengeRepository.findFirstByChallengeAndUser(challengeService.getChallenge(challengeId),userService.getUser(userId)) != null )
            return null;
        return userLikesChallengeRepository.save(userLikesChallenge);
    }
}
