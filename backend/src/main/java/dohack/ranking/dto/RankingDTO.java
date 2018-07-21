package dohack.ranking.dto;

public class RankingDTO {
   //region Attributes
   private long userId;
   private String userName;
   private int numbFinishedChallenges;
   //endregion
   
   //region Constructors
   public RankingDTO(long userId, String userName, int numbFinishedChallenges) {
      this.userId = userId;
      this.userName = userName;
      this.numbFinishedChallenges = numbFinishedChallenges;
   }
   
   public RankingDTO() {
   }
   //endregion
   
   //region Getter Setter
   public long getUserId() {
      return userId;
   }
   
   public void setUserId(long userId) {
      this.userId = userId;
   }
   
   public String getUserName() {
      return userName;
   }
   
   public void setUserName(String userName) {
      this.userName = userName;
   }
   
   public int getNumbFinishedChallenges() {
      return numbFinishedChallenges;
   }
   
   public void setNumbFinishedChallenges(int numbFinishedChallenges) {
      this.numbFinishedChallenges = numbFinishedChallenges;
   }
   //endregion
}
