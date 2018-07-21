package dohack.user.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    //region Attributes
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
    //endregion
    
    //region Constructors
    public User(String name, String password, Integer numberFinishedChallenges, String description) {
        this.name = name;
        this.password = password;
        this.numberFinishedChallenges = numberFinishedChallenges;
        this.description = description;
    }
    
    public User() {
    }
    //endregion
    
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
