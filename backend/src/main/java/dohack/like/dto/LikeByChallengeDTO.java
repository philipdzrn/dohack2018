package dohack.like.dto;

public class LikeByChallengeDTO {

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public boolean isCurrentUserLikedChallenge() {
        return currentUserLikedChallenge;
    }

    public void setCurrentUserLikedChallenge(boolean currentUserLikedChallenge) {
        this.currentUserLikedChallenge = currentUserLikedChallenge;
    }

    private int likeCount;
    private boolean currentUserLikedChallenge;

}
