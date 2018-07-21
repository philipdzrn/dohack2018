package dohack.challenge.controller;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/challenges")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Challenge>> getChallenges(@PathVariable Integer userId) {

        // TODO: auf ChallengeDTO umstellen
        List<Challenge> challengesByUser = challengeService.getChallengesByUser(userId);
        return new ResponseEntity(challengesByUser, HttpStatus.OK);
    }
    
    public List<Challenge> getRanking(){
        // Get all challenges
        List<Challenge> challenges = this.challengeService.getAllChallenges();
        
        // Sort all challenges by created At
        challenges.sort((a,b) -> a.getCreatedAt().compareTo(b.getCreatedAt()));
        
        // Create DTOs to send back to client
        List<ChallengeDTO> challengeDTOS = new ArrayList<>();
        for(Challenge challenge : challenges ){
            // todo
        }
        
        return null;
    }
}
