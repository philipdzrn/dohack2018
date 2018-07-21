package dohack.like.dto;

import dohack.challenge.model.Challenge;
import dohack.user.model.User;

import java.util.List;

public class ChallengeLikedByUsersDTO {

    private Challenge challenge;

    private List<User> users;

    public ChallengeLikedByUsersDTO(Challenge challenge, List<User> users) {
        this.challenge = challenge;
        this.users = users;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
