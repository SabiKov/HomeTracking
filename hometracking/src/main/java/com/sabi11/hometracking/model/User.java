package com.sabi11.hometracking.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "status")
    private boolean status;
    @Column(name = "email", nullable=false, unique=true)
    @NotEmpty
    @Email(message="{errors.invalid_email}")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password", nullable=false)
    @NotEmpty
    @Size(min=4)
    private String password;
    @Column(name = "user_name", nullable=false)
    @NotEmpty()
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
