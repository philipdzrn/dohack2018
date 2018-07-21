package dohack.challenge.dto;

import dohack.user.dto.UserDTO;

import java.util.Date;

public class ChallengeDTO {

    public String name;

    public String description;

    public Date start;

    public Date end;

    public Integer goal;

    public Integer currentValue;

    public Boolean isFinished;
    
    public Date createdAt;

    public Date updatedAt;
    
    public UserDTO creator;
    
    
    
    //region Getter Setter
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
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public UserDTO getCreator() {
        return creator;
    }
    
    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    //endregion
}
