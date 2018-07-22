package dohack.userAcceptsChallenge.controller;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import dohack.user.dto.UserDTO;
import dohack.user.model.User;
import dohack.user.service.UserService;
import dohack.userAcceptsChallenge.model.UserAcceptsChallenge;
import dohack.userAcceptsChallenge.service.UserAcceptsChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserAcceptsChallengeController {
   @Autowired
   private UserAcceptsChallengeService userAcceptsChallengeService;
   @Autowired
   private UserService userService;
   @Autowired
   private ChallengeService challengeService;
   
   /**
    * Return all challenges accepted by a user
    * @param userId
    * @return
    */
   @RequestMapping(value = "/accepted/users/{userId}/challenges", method = RequestMethod.GET)
   public List<ChallengeDTO> getChallengeDTOs(@RequestHeader(value = "userId") Integer userId) {
      
      return userAcceptsChallengeService.getAllChallengeDTOsByUser(userService.getUser(userId));
   }
   
   /**
    * Return all users who accepted a particular challenge
    * @param challengeId
    * @return
    */
   @RequestMapping(value = "/accepted/challenges/{challengeId}/users", method = RequestMethod.GET)
   public List<UserDTO> getUserDTOs(@RequestHeader(value = "challengeId") Integer challengeId) {
      
      return userAcceptsChallengeService.getAllUserDTOsByChallenge(challengeService.getChallenge(challengeId));
   }
   
   /**
    * Add an existed challenge to a user
    * @param userId
    * @param challengeId
    * @return
    */
   @RequestMapping(value = "/accepted/users/{userId}/challenges/{challengeId}", method = RequestMethod.POST)
   public UserAcceptsChallenge addChallengeToUser(@RequestHeader(value = "userId") Integer userId, @RequestHeader(value = "challengeId") Integer challengeId){
      return userAcceptsChallengeService.createUserAcceptsChallenge(userId, challengeId);
   }
   
   /**
    * Delete particular challenge accepted by a user
    * @param userId
    * @param challengeId
    */
   @RequestMapping(value = "/accepted/users/{userId}/challenges/{challengeId}", method = RequestMethod.DELETE)
   public void deleteChallengeFromUser(@RequestHeader(value = "userId") Integer userId, @RequestHeader(value = "challengeId") Integer challengeId){
      userAcceptsChallengeService.delete(userId, challengeId);
   }
}
