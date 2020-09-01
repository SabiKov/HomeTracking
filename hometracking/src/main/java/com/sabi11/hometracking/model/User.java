package com.sabi11.hometracking.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id", length=12, nullable = false, unique = true)
    private long userId;

    @Column(name = "status")
    private boolean status;

    @Email(message="{errors.invalid_email}")
    @NotEmpty(message = "E-mail address is mandatory field. Please provide an e-mail")
    @Column(name = "email", length = 70, nullable = false)
    private String email;

    @Size(min=2, message = "First name should have at least 2 characters")
    @NotEmpty(message = "First name is mandatory field. Please provide a first name")
    @Column(name = "first_name", length = 140, nullable = false)
    private String firstName;

    @Size(min=2, message = "Last name should have at least 2 characters")
    @NotEmpty(message = "Last name is mandatory field. Please provide a last name")
    @Column(name = "last_name", length = 140, nullable = false)
    private String lastName;

    @Size(min=4, message = "Password should have at least 4 characters")
    @NotEmpty(message = "Password is mandatory field. Please provide a password")
    @Column(name = "password", length = 16,  nullable = false)
    private String password;

    @Size(min=2, message = "User name should have at least 4 characters")
    @NotEmpty(message = "User name is mandatory field. Please provide a user name")
    @Column(name = "user_name", length = 30, nullable = false)
    private String userName;

    @NotEmpty(message = "Role is mandatory field. Please provide a role")
    @Column(name = "role", length = 16, nullable = false)
    private String role;

    @Column(name = "unsuccess_login")
    private String unsuccessLogin;

    @Column(name = "num_unsuccess_login_attempt")
    private Integer numUnsuccessLoginAttempt;

    @Column(name = "success_login")
    private String successLogin;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "role_id")})
    private List<Role> roles;
}
