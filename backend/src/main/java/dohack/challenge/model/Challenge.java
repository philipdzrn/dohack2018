package dohack.challenge.model;


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
    private Date start;

    @Basic
    @Column
    private Date end;

    @Basic
    @Column
    private int goal;


    // TODO: creator auf User umstellen
    @Basic
    @Column
    private String creator;

}
