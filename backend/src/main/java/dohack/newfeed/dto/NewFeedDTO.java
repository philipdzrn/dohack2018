package dohack.newfeed.dto;

import dohack.challenge.dto.ChallengeDTO;

public class NewFeedDTO {

    private ChallengeDTO challengeDTO;

    private Integer likesNumber;

    public ChallengeDTO getChallengeDTO() {
        return challengeDTO;
    }

    public void setChallengeDTO(ChallengeDTO challengeDTO) {
        this.challengeDTO = challengeDTO;
    }

    public Integer getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(Integer likesNumber) {
        this.likesNumber = likesNumber;
    }
}
