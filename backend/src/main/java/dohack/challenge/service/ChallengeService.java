package dohack.challenge.service;

import dohack.challenge.model.Challenge;
import dohack.challenge.repo.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    public List<Challenge> getChallengesByUser(Integer userId) {
     // challengeRepository.findByCreator()

        return Collections.emptyList();
    }
}
