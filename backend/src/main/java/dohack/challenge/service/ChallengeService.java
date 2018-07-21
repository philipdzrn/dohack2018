package dohack.challenge.service;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.repo.ChallengeRepository;
import dohack.user.model.User;
import dohack.user.repo.UserRepository;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    // TODO: entfernen
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public List<Challenge> getChallengesByUser(Integer userId) {
        return challengeRepository.findByCreator(userRepository.findById(userId).get());
    }

    public List<Challenge> getChallengesByUser(String userId) {
        return challengeRepository.findByCreator(userRepository.findFirstByName(userId));
    }


    public List<Challenge> getAllChallenges() {
        return (List) challengeRepository.findAll();
    }

    public Challenge createNewChallenge(ChallengeDTO challengeDTO, String userId) {

        // TODO:
        User user = userRepository.findFirstByName(userId);

        Challenge challenge = new Challenge();
        challenge.setName(challengeDTO.getName());
        challenge.setDescription(challengeDTO.getDescription());
        challenge.setStartDate(challengeDTO.getStart());
        challenge.setEndDate(challengeDTO.getEnd());
        challenge.setFinished(false);
        challenge.setGoal(challengeDTO.getGoal());
        challenge.setCreator(user);
        return challengeRepository.save(challenge);
    }

    public ChallengeDTO getChallengeDTOFromChallenge(Challenge challenge) {
        ChallengeDTO challengeDTO = new ChallengeDTO();
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
     * @param challengesByUser
     * @return
     */
    public List<ChallengeDTO> getAllChallengeDTOs(List<Challenge> challengesByUser){
        List<ChallengeDTO> challengeDTOS = new ArrayList<>();
        for(Challenge challenge : challengesByUser){
            challengeDTOS.add(getChallengeDTOFromChallenge(challenge));
        }
        
        return challengeDTOS;
    }
}
