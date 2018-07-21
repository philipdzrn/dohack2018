package dohack.newfeed.service;

import dohack.challenge.dto.ChallengeDTO;
import dohack.challenge.service.ChallengeService;
import dohack.newfeed.dto.NewFeedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewFeedService {

    @Autowired
    private ChallengeService challengeService;

    public List<NewFeedDTO> getNewFeeds() {
        List<ChallengeDTO> challenges = challengeService.getAllChallengeDTOs(challengeService.getAllChallenges()) ;
        List<NewFeedDTO> newFeeds = new ArrayList<>();

        for( ChallengeDTO challenge : challenges ) {
            NewFeedDTO newFeedDTO = new NewFeedDTO();
            newFeedDTO.setChallengeDTO(challenge);
            //TODO newfeed likesnumber
            //newFeedDTO.setLikesNumber();
        }

        return newFeeds;
    }
}
