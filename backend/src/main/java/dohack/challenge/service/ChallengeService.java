package dohack.challenge.service;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.repo.ChallengeRepository;
import dohack.user.model.User;
import dohack.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Challenge> getChallengesByUser(Integer userId) {
        return challengeRepository.findByCreator(userRepository.findById(userId).get());
    }

    public List<Challenge> getChallengesByUser(String userId) {
        return challengeRepository.findByCreator(userRepository.findFirstByName(userId));
    }


    public List<Challenge> getAllChallenges() {
        return (List) challengeRepository.findAll();
    }

    public Challenge createNewChallenge(ChallengeDTO challengeDTO, User user) {
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
        challengeDTO.setCreator(challenge.getCreator());
        return challengeDTO;
    }
}
