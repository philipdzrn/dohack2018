package dohack.challenge.service;

import dohack.challenge.model.Challenge;
import dohack.challenge.repo.ChallengeRepository;
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
}
