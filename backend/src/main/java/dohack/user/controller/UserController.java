package dohack.user.controller;

import dohack.challenge.dto.ChallengeDTO;
import dohack.user.dto.UserDTO;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user/{userId}")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ChallengeDTO>> overview(@PathVariable("userId") Integer userId) {
        return new ResponseEntity(userService.getChallenges(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "/profile")
    public UserDTO getProfile(@PathVariable("userId") Integer userId) {
        return userService.getUserDTOFromUser(userService.getUser(userId));
    }

    /*
    @RequestMapping(value = "/createChallenge", method = RequestMethod.POST )
    public ResponseEntity<List<ChallengeDTO>> createChallenge(@PathVariable("userId") Integer userId, @RequestBody ChallengeDTO challengeDTO) {
        return new ResponseEntity(userService.createNewChallenge(userId,challengeDTO), HttpStatus.OK);
    }
    */
}
