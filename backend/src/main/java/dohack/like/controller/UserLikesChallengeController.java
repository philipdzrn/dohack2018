package dohack.like.controller;

import dohack.like.service.UserLikesChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserLikesChallengeController {

    @Autowired
    private UserLikesChallengeService userLikesChallengeService;

    @RequestMapping( value= "/challenge/{challengeId}/like", method = RequestMethod.POST )
    public ResponseEntity addUserLikesChallenge(@RequestHeader(value = "userid") Integer userId, @PathVariable("challengeId") Integer challengeId) {
        userLikesChallengeService.addUserLikesChallenge( userId, challengeId );
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
