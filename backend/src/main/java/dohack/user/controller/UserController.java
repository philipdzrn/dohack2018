package dohack.user.controller;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import dohack.user.dto.UserDTO;
import dohack.user.model.User;
import dohack.user.repo.UserRepository;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user/{userId}")
public class UserController {

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ChallengeDTO>> overview(@PathVariable("userId") String userId) {
        List<Challenge> challenges = challengeService.getChallengesByUser(userId);
        List<ChallengeDTO> dtoChallenges = new ArrayList<>();
        for( Challenge challenge : challenges )
            dtoChallenges.add( challengeService.getChallengeDTOFromChallenge(challenge) );

        return new ResponseEntity(dtoChallenges, HttpStatus.OK);
    }

    @RequestMapping(value = "/profile")
    public UserDTO getProfile(@PathVariable("userId") String userId) {
        return userService.getUserDTOFromUser(userRepository.findFirstByName(userId));
    }

    @RequestMapping(value = "/createChallenge", method = RequestMethod.POST )
    public ResponseEntity<List<ChallengeDTO>> createChallenge(@PathVariable("userId") String userId, @RequestBody ChallengeDTO challengeDTO) {
        User user = userRepository.findFirstByName(userId);
        challengeService.createNewChallenge(challengeDTO,user);

        List<Challenge> challenges = challengeService.getChallengesByUser(userId);
        List<ChallengeDTO> dtoChallenges = new ArrayList<ChallengeDTO>();
        for( Challenge challenge : challenges )
            dtoChallenges.add( challengeService.getChallengeDTOFromChallenge(challenge) );

        return new ResponseEntity(dtoChallenges, HttpStatus.OK);
    }
}
