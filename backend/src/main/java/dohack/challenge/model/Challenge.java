package dohack.challenge.model;


import dohack.user.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "challenges")
public class Challenge implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

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
    private Boolean isFinished;

    @ManyToOne
    private User creator;

    /*
    @OneToMany( targetEntity = UserLikesChallenge.class )
    List<UserLikesChallenge> usersLiked;
    */

    //region Getter Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    //endregion
}
