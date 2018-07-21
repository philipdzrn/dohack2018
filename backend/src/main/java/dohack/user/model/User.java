package dohack.user.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    @Column
    private String name;

    @Basic
    @Column
    private String password;

    @Basic
    @Column
    private Integer numberFinishedChallenges;

    @Basic
    @Column
    private String description;

    /*
    @OneToMany( targetEntity = Challenge.class )
    List<Challenge> challenges;

    @OneToMany( targetEntity = UserLikesChallenge.class )
    List<UserLikesChallenge> challengesLiked;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNumberFinishedChallenges() {
        return numberFinishedChallenges;
    }

    public void setNumberFinishedChallenges(Integer numberFinishedChallenges) {
        this.numberFinishedChallenges = numberFinishedChallenges;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //endregion
}
