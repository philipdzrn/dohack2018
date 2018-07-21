package dohack.user.dto;

public class UserDTO {

    private Integer id;

    private String name;

    private String description;

    private Integer numberFinishedChallenges;

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

    public Integer getNumberFinishedChallenges() {
        return numberFinishedChallenges;
    }

    public void setNumberFinishedChallenges(Integer numberFinishedChallenges) {
        this.numberFinishedChallenges = numberFinishedChallenges;
    }
}
