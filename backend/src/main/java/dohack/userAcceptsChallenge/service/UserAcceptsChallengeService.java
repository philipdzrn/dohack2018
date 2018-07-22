package dohack.userAcceptsChallenge.service;


import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import dohack.user.dto.UserDTO;
import dohack.user.model.User;
import dohack.user.service.UserService;
import dohack.userAcceptsChallenge.model.UserAcceptsChallenge;
import dohack.userAcceptsChallenge.repo.UserAcceptsChallengeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserAcceptsChallengeService {
   @Autowired
   private UserAcceptsChallengeRepo userAcceptsChallengeRepo;
   @Autowired
   private UserService userService;
   @Autowired
   private ChallengeService challengeService;
   
   /**
    * Return all users by a challenge
    * @param challenge
    * @return
    */
   public List<User> getAllUsersByChallenge(Challenge challenge){
      
      return userAcceptsChallengeRepo.findByChallenge(challenge);
   }
   
   /**
    * Return all user DTOs by a challenge
    * @param challenge
    * @return
    */
   public List<UserDTO> getAllUserDTOsByChallenge(Challenge challenge){
      List<UserDTO> userDTOS = new ArrayList<>();
      
      for(User user : getAllUsersByChallenge(challenge)){
         UserDTO userDTO = userService.getUserDTOFromUser(user);
         userDTOS.add(userDTO);
      }
      
      return userDTOS;
   }
   
   /**
    * Return all challenges by an user
    * @param user
    * @return
    */
   public List<Challenge> getAllChallengesByUser(User user){
      
      return userAcceptsChallengeRepo.findByUser(user);
   }
   
   /**
    * Return all challenge DTOs by an user
    * @param user
    * @return
    */
   public List<ChallengeDTO> getAllChallengeDTOsByUser(User user){
      List<ChallengeDTO> challengeDTOs = new ArrayList<>();
      
      for(Challenge challenge : getAllChallengesByUser(user)){
         ChallengeDTO challengeDTO = challengeService.getChallengeDTOFromChallenge(challenge);
         challengeDTOs.add(challengeDTO);
      }
      
      return challengeDTOs;
   }
   
   /**
    * Delete a challenge of an user from database
    * @param userId
    * @param challengeId
    */
   public void delete(Integer userId, Integer challengeId){
      User user = userService.getUser(userId);
      Challenge challenge = challengeService.getChallenge(challengeId);
      
      userAcceptsChallengeRepo.deleteByChallengeAndUser(challenge, user);
   }
   
   /**
    * Add a new challenge for an user to database
    * @param userId
    * @param challengeId
    * @return
    */
   public UserAcceptsChallenge createUserAcceptsChallenge(Integer userId, Integer challengeId){
      User user = userService.getUser(userId);
      Challenge challenge = challengeService.getChallenge(challengeId);
      UserAcceptsChallenge userAcceptsChallenge = new UserAcceptsChallenge(user, challenge);
      
      return userAcceptsChallengeRepo.save(userAcceptsChallenge);
   }
   
}
