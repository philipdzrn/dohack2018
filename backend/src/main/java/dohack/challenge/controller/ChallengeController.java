package dohack.challenge.controller;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.repo.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/challenges")
public class ChallengeController {

    @Autowired
    private ChallengeRepository challengeRepository;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<String> getChallenges(@PathVariable Integer userId) {

        Challenge challenge = new Challenge();
        challengeRepository.save(challenge);
        return new ResponseEntity(new ChallengeDTO(), HttpStatus.OK);
    }
}
