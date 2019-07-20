package br.edu.ifpb.bicos.entity;



import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    @Transient
    private String passwordConfirm;

    private String name;
    private String document;
    private Date birthdate;
    private String email;
    private String number;
    private String imageURL;
    private String bio;
    private int helpfulnessRating = 0;
    private int punctualityRating = 0;
    private int sympathyRating = 0;

    private boolean isAdmin;



    @ManyToMany
    private Set<Role> roles;

//    @OneToMany
//    private List<Event> events = new ArrayList<>();

}
