package dohack.challenge.controller;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ChallengeDTO> getChallengeDTOs(@RequestHeader(value = "userid") Integer userId) {
        return challengeService.getAllChallengeDTOs(challengeService.getAllChallenges());
    }


    @RequestMapping(value = "/{challengeId}", method = RequestMethod.GET)
    public ChallengeDTO getChallengeDTO(@RequestHeader(value = "userid") Integer userId, @PathVariable("challengeId") Integer challengeId) {
        return challengeService.getChallegeDTO(challengeId);
    }

    @RequestMapping(value = "/{challengeId}", method = RequestMethod.POST)
    public ResponseEntity updateCurrentValue(@PathVariable("challengeId") Integer challengeId, @RequestBody Integer currentValue) {
        challengeService.updateCurrentValue(challengeId, currentValue);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/createChallenge", method = RequestMethod.POST)
    public ResponseEntity createChallenge(@RequestHeader(value = "userid") Integer userId, @RequestBody ChallengeDTO challengeDTO) {
        challengeService.createNewChallenge(userId, challengeDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{userId}/challenges", method = RequestMethod.GET)
    public ResponseEntity<List<Challenge>> getUserChallengeDTOs(@PathVariable Integer userId) {
        List<ChallengeDTO> challengeDTOS = challengeService.getChallengeDTOsByUser(userId);
        return new ResponseEntity(challengeDTOS, HttpStatus.OK);
    }

    //endregion
}
