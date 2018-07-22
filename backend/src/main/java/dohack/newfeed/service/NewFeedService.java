package dohack.newfeed.service;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.model.Challenge;
import dohack.challenge.service.ChallengeService;
import dohack.like.service.UserLikesChallengeService;
import dohack.newfeed.dto.NewFeedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewFeedService {
   
   @Autowired
   private ChallengeService challengeService;
   
   @Autowired
   private UserLikesChallengeService userLikesChallengeService;
   
   public List<NewFeedDTO> getAllNewFeeds() {
      // Get all challenges
      List<Challenge> challenges = this.challengeService.getAllChallenges();
      
      // Get all challenge DTOs
      List<ChallengeDTO> challengeDTOs = this.challengeService.getAllChallengeDTOs(challenges);
      
      // Create new feed list to return
      List<NewFeedDTO> newFeeds = new ArrayList<>();
      
      for (int i = 0; i < challenges.size(); i++) {
         // Get like number by challenge
         int likeNumber = this.userLikesChallengeService.getLikesByChallenge(challenges.get(i));
         
         // Create a NewFeedDTO
         NewFeedDTO newFeedDTO = new NewFeedDTO();
         newFeedDTO.setChallengeDTO(challengeDTOs.get(i));
         newFeedDTO.setLikesNumber(likeNumber);
         
         // Push the object to newFeeds list
         newFeeds.add(newFeedDTO);
      }
      
      newFeeds.sort((a,b) -> b.getChallengeDTO().updatedAt.compareTo(a.getChallengeDTO().updatedAt));
      
      return newFeeds;
   }
}
