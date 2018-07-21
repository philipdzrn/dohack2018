package dohack.challenge.dto;

import java.util.Date;

public class ChallengeDTO {

    public String name;

    public String description;

    public Date start;

    public Date end;

    public Integer goal;

    public Boolean isFinished;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getGoal() {
        return goal;
    }

    public void setGoal(Integer goal) {
        this.goal = goal;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

  /* TODO remove
  public String getMessage() {
    return message;
  }

  private String message = "Erfolg";
  */

}
