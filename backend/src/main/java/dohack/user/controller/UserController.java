package dohack.user.controller;

import dohack.user.dto.UserDTO;
import dohack.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("userId") Integer userId) {
        return userService.getUserDTOFromUser(userService.getUser(userId));
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> getUsers() {
        return userService.getAllUserDTOs();
    }

    /*
    @RequestMapping(value = "/createChallenge", method = RequestMethod.POST )
    public ResponseEntity<List<ChallengeDTO>> createChallenge(@PathVariable("userId") Integer userId, @RequestBody ChallengeDTO challengeDTO) {
        return new ResponseEntity(userService.createNewChallenge(userId,challengeDTO), HttpStatus.OK);
    }
    */
}
