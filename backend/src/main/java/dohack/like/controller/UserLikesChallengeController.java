package dohack.like.controller;

import dohack.like.dto.LikeByChallengeDTO;
import dohack.like.model.UserLikesChallenge;
import dohack.like.service.UserLikesChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserLikesChallengeController {

    @Autowired
    private UserLikesChallengeService userLikesChallengeService;

    @RequestMapping( value= "/challenges/{challengeId}/like", method = RequestMethod.POST )
    public ResponseEntity addUserLikesChallenge(@RequestHeader(value = "userid") Integer userId, @PathVariable("challengeId") Integer challengeId) {
        UserLikesChallenge temp = userLikesChallengeService.addUserLikesChallenge( userId, challengeId);
        System.out.println(temp);
        if( temp == null )
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping( value= "/challenges/{challengeId}/likes", method = RequestMethod.GET )
    public ResponseEntity<LikeByChallengeDTO> getLikes(@RequestHeader(value = "userid") Integer userId, @PathVariable("challengeId") Integer challengeId){
        LikeByChallengeDTO likeCountByChallengeId = userLikesChallengeService.getLikeCountByChallengeId(userId, challengeId);
        return new ResponseEntity(likeCountByChallengeId, HttpStatus.OK);
    }
}
