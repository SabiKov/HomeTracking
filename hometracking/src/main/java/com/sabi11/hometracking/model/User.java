package com.sabi11.hometracking.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "status")
    private boolean status;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "role")
    private String role;
    @Column(name = "unsuccess_login")
    private String unsuccessLogin;
    @Column(name = "num_unsuccess_login_attempt")
    private Integer numUnsuccessLoginAttempt;
    @Column(name = "success_login")
    private String successLogin;

}
