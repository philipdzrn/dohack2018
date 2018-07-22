package dohack.userHasFriends.controller;

import dohack.user.dto.UserDTO;
import dohack.userHasFriends.service.UserHasFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserHasFriendsController {

    @Autowired
    private UserHasFriendsService userHasFriendsService;

    @RequestMapping(value = "/users/{userId}/friends", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getFriendDTOs(@PathVariable("userid") Integer userId) {
        return new ResponseEntity(userHasFriendsService.getFriendDTOs(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{userId}/friends/", method = RequestMethod.POST)
    public ResponseEntity<String> addFriend(@PathVariable("userid") Integer userId, @RequestBody Integer friendId) {
        userHasFriendsService.addFriend(userId, friendId);
        return new ResponseEntity("redirect:/users/{userId}/friends", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{userId}/friends/{friendId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeFriend(@PathVariable("userid") Integer userId, @PathVariable("friendId") Integer friendId) {
        userHasFriendsService.removeFriend(userId, friendId);
        return new ResponseEntity("redirect:/users/{userId}/friends", HttpStatus.OK);
    }

}
