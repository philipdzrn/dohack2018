package dohack.like.dto;

import dohack.challenge.model.Challenge;
import dohack.user.model.User;

import java.util.List;

public class UserLikesChallengeDTO {

    private User user;

    private List<Challenge> challenges;

    public UserLikesChallengeDTO(User user, List<Challenge> challenges) {
        this.user = user;
        this.challenges = challenges;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }
}
