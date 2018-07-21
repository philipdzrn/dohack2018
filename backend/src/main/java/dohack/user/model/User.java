package dohack.user.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    //region Attributes
    @Id
    @GeneratedValue
    private Integer id;

    @Basic
    @Column
    private String name;

    @Basic
    @Column
    private String password;

    @Basic
    @Column
    private String description;
    //endregion
    
    //region Constructors
    public User(String name, String password, String description) {
        this.name = name;
        this.password = password;
        this.description = description;
    }
    
    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //endregion
}
