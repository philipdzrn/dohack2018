package dohack.challenge.model;


import dohack.user.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "challenges")
public class Challenge implements Serializable {

    //region Attributes
    @Id
    @GeneratedValue
    private Integer id;

    @Basic
    @Column
    private String name;

    @Basic
    @Column
    private String description;

    @Basic
    @Column
    private Date startDate;

    @Basic
    @Column
    private Date endDate;

    @Basic
    @Column
    private Integer goal;

    @Basic
    @Column
    private Integer currentValue;

    @Basic
    @Column
    private Boolean isFinished;

    @Basic
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Basic
    @Column
    private Date updatedAt;

    @ManyToOne
    private User creator;
    //endregion

    //region Constructors
    public Challenge(String name, String description, Date startDate, Date endDate, Integer goal, Integer currentValue, Boolean isFinished, Date createdAt, Date updatedAt, User creator) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.goal = goal;
        this.currentValue = currentValue;
        this.isFinished = isFinished;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.creator = creator;
    }

    public Challenge() {
    }
    //endregion

    //region Getter Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }

    //endregion

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        createdAt = now;
        startDate = now;
        updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        Date now = new Date();
        updatedAt = now;
    }
}
