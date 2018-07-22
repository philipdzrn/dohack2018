package dohack.challenge.service;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.repo.ChallengeRepository;
import dohack.like.service.UserLikesChallengeService;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserLikesChallengeService userLikesChallengeService;

    /**
     * Returns all Challenges from a User
     *
     * @param userId
     * @return
     */
    public List<ChallengeDTO> getChallengeDTOsByUser(Integer userId) {
        List<Challenge> challenges = challengeRepository.findByCreator(userService.getUser(userId));
        return getAllChallengeDTOs(challenges);
    }

    /**
     * Update currentValue of a Challenge
     *
     * @param challengeId
     * @param currentValue
     */
    public void updateCurrentValue(Integer challengeId, Integer currentValue) {
        Challenge challenge = challengeRepository.findById(challengeId).get();
        challenge.setUpdatedAt(new Date());

        if( currentValue != null ) {
            challenge.setCurrentValue(challenge.getCurrentValue() + currentValue);

            if (challenge.getCurrentValue() >= challenge.getGoal())
                challenge.setFinished(true);

            challengeRepository.save(challenge);
        }
    }

    /**
     * Creates a new Challenge
     *
     * @param challengeDTO
     * @param userId
     * @return
     */
    public void createNewChallenge(Integer userId, ChallengeDTO challengeDTO) {
        Challenge challenge = new Challenge();
        challenge.setName(challengeDTO.getName());
        challenge.setDescription(challengeDTO.getDescription());
        challenge.setStartDate(challengeDTO.getStart());
        challenge.setEndDate(challengeDTO.getEndDate());
        challenge.setFinished(false);
        challenge.setGoal(challengeDTO.getGoal());
        challenge.setCreator(userService.getUser(userId));
        challenge.setCurrentValue(0);
        challenge.setUpdatedAt(null);
        challengeRepository.save(challenge);
    }

    /**
     * Creates a ChallengeDTO from a Challenge
     *
     * @param challenge
     * @return
     */
    public ChallengeDTO getChallengeDTOFromChallenge(Challenge challenge) {
        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.setId(challenge.getId());
        challengeDTO.setName(challenge.getName());
        challengeDTO.setDescription(challenge.getDescription());
        challengeDTO.setStart(challenge.getStartDate());
        challengeDTO.setEndDate(challenge.getEndDate());
        challengeDTO.setGoal(challenge.getGoal());
        challengeDTO.setFinished(challenge.getFinished());
        challengeDTO.setCreatedAt(challenge.getCreatedAt());
        challengeDTO.setCreator(userService.getUserDTOFromUser(challenge.getCreator()));
        challengeDTO.setCurrentValue(challenge.getCurrentValue());
        challengeDTO.setUpdatedAt(challenge.getUpdatedAt());
        return challengeDTO;
    }

    public Challenge getChallenge( Integer challengeId ) {
        return challengeRepository.findById(challengeId).get();
    }

    public ChallengeDTO getChallegeDTO( Integer challengeId ) {
        return getChallengeDTOFromChallenge( getChallenge(challengeId) );
    }

    /**
     * Returns all existing Challenges
     *
     * @return
     */
    public List<Challenge> getAllChallenges() {
        return (List) challengeRepository.findAll();
    }

    /**
     * Get all challenge DTOs from challenge list
     *
     * @param challengesByUser
     * @return
     */
    public List<ChallengeDTO> getAllChallengeDTOs(List<Challenge> challengesByUser) {
        List<ChallengeDTO> challengeDTOS = new ArrayList<>();
        for (Challenge challenge : challengesByUser)
            challengeDTOS.add(getChallengeDTOFromChallenge(challenge));

        challengeDTOS.sort( (arg1, arg2) -> arg1.getEndDate().compareTo(arg2.getEndDate()));

        return challengeDTOS;
    }
    
    
}
