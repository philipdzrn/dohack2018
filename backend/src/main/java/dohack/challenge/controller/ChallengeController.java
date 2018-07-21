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
import org.springframework.web.bind.annotation.*;

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
     * Update a Challenge
     *
     * @param challengeId
     * @return
     */
    @RequestMapping(value = "/{challengeId}", method = RequestMethod.POST)
    public ResponseEntity updateChallenge(@PathVariable Integer challengeId, @RequestBody Integer currentValue ) {
        challengeService.updateCurrentValue(challengeId, currentValue);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Return all challenges from a user
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Challenge>> getChallenges(@PathVariable Integer userId) {

        // Get all challenges by user
        List<ChallengeDTO> challengeDTOS = challengeService.getChallengesByUser(userId);

        return new ResponseEntity(challengeDTOS, HttpStatus.OK);
    }

    /**
     * Return list of all users sorted by number challenges finished
     *
     * @return
     */
    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public List<UserDTO> getRanking() {
        // Get all users
        List<User> users = this.userService.getAllUsers();

        // Sort all users by numbChallengesFinished
        // todo number
//        users.sort((a, b) -> a.getNumberFinishedChallenges() - (b.getNumberFinishedChallenges()));

        // Create DTOs to send back to client
        List<UserDTO> userDTOS = this.userService.getAllUserDTOs(users);

        return userDTOS;
    }
    //endregion
}
