package dohack.userHasFriends.model;

import dohack.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "userHasFriends")
public class UserHasFriends {

    //region Attributes
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToOne
    private User friend;
    //endregion

    //region Constructors
    public UserHasFriends() {
    }

    public UserHasFriends(User user, User friend) {
        this.user = user;
        this.friend = friend;
    }
    //endregion

    //region Getter Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
    //endregion
}
