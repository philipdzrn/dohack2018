package dohack.challenge.service;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.repo.ChallengeRepository;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private UserService userService;

    public List<ChallengeDTO> getChallengesByUser(Integer userId) {
        List<Challenge> challenges = challengeRepository.findByCreator(userService.getUser(userId));
        return getAllChallengeDTOs(challenges);
    }

    public ChallengeDTO updateChallenge(ChallengeDTO challengeDTO) {
        Challenge challenge = challengeRepository.findFirstByName(challengeDTO.getName());
        //challenge.se

        return challengeDTO;
    }

    public List<Challenge> getAllChallenges() {
        return (List) challengeRepository.findAll();
    }

    public Challenge createNewChallenge(ChallengeDTO challengeDTO, Integer userId) {
        Challenge challenge = new Challenge();
        challenge.setName(challengeDTO.getName());
        challenge.setDescription(challengeDTO.getDescription());
        challenge.setStartDate(challengeDTO.getStart());
        challenge.setEndDate(challengeDTO.getEnd());
        challenge.setFinished(false);
        challenge.setGoal(challengeDTO.getGoal());
        challenge.setCreator(userService.getUser(userId));
        return challengeRepository.save(challenge);
    }

    public ChallengeDTO getChallengeDTOFromChallenge(Challenge challenge) {
        ChallengeDTO challengeDTO = new ChallengeDTO();
        challengeDTO.setId(challenge.getId());
        challengeDTO.setName(challenge.getName());
        challengeDTO.setDescription(challenge.getDescription());
        challengeDTO.setStart(challenge.getStartDate());
        challengeDTO.setEnd(challenge.getEndDate());
        challengeDTO.setGoal(challenge.getGoal());
        challengeDTO.setFinished(challenge.getFinished());
        challengeDTO.setCreatedAt(challenge.getCreatedAt());
        challengeDTO.setCreator(userService.getUserDTOFromUser(challenge.getCreator()));
        return challengeDTO;
    }

    /**
     * Get all challenge DTOs from challenge list
     *
     * @param challengesByUser
     * @return
     */
    public List<ChallengeDTO> getAllChallengeDTOs(List<Challenge> challengesByUser) {
        List<ChallengeDTO> challengeDTOS = new ArrayList<>();
        for (Challenge challenge : challengesByUser) {
            challengeDTOS.add(getChallengeDTOFromChallenge(challenge));
        }

        return challengeDTOS;
    }
}
