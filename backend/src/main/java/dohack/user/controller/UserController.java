package dohack.user.controller;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import dohack.ranking.service.RankingService;
import dohack.user.dto.UserDTO;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private RankingService rankingService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> getUsers() {
        return userService.getAllUserDTOs();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("userId") Integer userId) {
        UserDTO userDTO = userService.getUserDTOFromUser(userService.getUser(userId));
        Integer temp = rankingService.getNumbFinishedChallenges(userService.getUser(userId));
        userDTO.setNumberFinishedChallenges(temp);
        return userDTO;
    }

    @RequestMapping(value = "/users/{userId}/challenges", method = RequestMethod.GET)
    public ResponseEntity<List<Challenge>> getUserChallengeDTOs(@PathVariable Integer userId) {
        List<ChallengeDTO> challengeDTOS = challengeService.getChallengeDTOsByUser(userId);
        return new ResponseEntity(challengeDTOS, HttpStatus.OK);
    }
    /*
    @RequestMapping(value = "/createChallenge", method = RequestMethod.POST )
    public ResponseEntity<List<ChallengeDTO>> createChallenge(@PathVariable("userId") Integer userId, @RequestBody ChallengeDTO challengeDTO) {
        return new ResponseEntity(userService.createNewChallenge(userId,challengeDTO), HttpStatus.OK);
    }
    */
}
