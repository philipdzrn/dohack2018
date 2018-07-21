package dohack.challenge.controller;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import dohack.user.dto.UserDTO;
import dohack.user.model.User;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/challenges")
public class ChallengeController {
    
    //region Attributes
    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private UserService userService;
    //endregion
    
    //region Routes
    
    /**
     * Return all challenges from a user
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Challenge>> getChallenges(@PathVariable Integer userId) {

        // Get all challenges by user
        List<Challenge> challengesByUser = challengeService.getChallengesByUser(userId);
        
        // Create all challenge DTOs to send back to client
        List<ChallengeDTO> challengeDTOS = new ArrayList<>();
        for(Challenge challenge : challengesByUser){
            challengeDTOS.add(this.challengeService.getChallengeDTOFromChallenge(challenge));
        }
        
        return new ResponseEntity(challengeDTOS, HttpStatus.OK);
    }
    
    /**
     * Return list of all users sorted by number challenges finished
     * @return
     */
    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public List<UserDTO> getRanking(){
        // Get all users
        List<User> users = this.userService.getAllUsers();

        // Sort all users by numbChallengesFinished
        users.sort((a,b) -> a.getNumberFinishedChallenges() - (b.getNumberFinishedChallenges()));

        // Create DTOs to send back to client
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user : users ){
            userDTOS.add(this.userService.getUserDTOFromUser(user));
        }

        return userDTOS;
    }
    //endregion
}
