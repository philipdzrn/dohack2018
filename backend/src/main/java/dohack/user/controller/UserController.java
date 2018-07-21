package dohack.user.controller;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import dohack.user.dto.UserDTO;
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
@RequestMapping( value = "/user/{userId}")
public class UserController {

  @Autowired
  private ChallengeService challengeService;

  @RequestMapping( "/profile" )
  public UserDTO getUser(@PathVariable("userId") String userId ) {
    //TODO User-Profil laden
    UserDTO user = null;
    return user;
  }

  @RequestMapping( "/challenges", method = RequestMethod.GET )
  public ResponseEntity<List<ChallengeDTO>> getChallenges(@PathVariable("userId") Integer userId ) {
    List<Challenge> challenges = challengeService.getChallengesByUser(userId);
    List<ChallengeDTO> dtoChallenges = new ArrayList<ChallengeDTO>();
    challenges.forEach( arg  -> {
            ChallengeDTO dtoChallenge = new ChallengeDTO();
            dtoChallenge.setName(arg.getName());
            dtoChallenges.add( dtoChallenge );
    };
    return new ResponseEntity( dtoChallenges, HttpStatus.OK );
  }
}
