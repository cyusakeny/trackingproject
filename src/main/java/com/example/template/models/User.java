package com.example.template.models;

import com.example.template.enums.EGender;
import com.example.template.enums.EStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = { "mobile" }), @UniqueConstraint(columnNames = { "email" }) })
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;
    private String firstName;
    private String lastName;
    private String mobile;
    @Enumerated(EnumType.STRING)
    private EGender gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EStatus status = EStatus.ACTIVE;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private  Set<Assets> assets;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "sentBy", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Reviews> reviews;


    @JsonIgnore
    private String password;

    public User(String email, String firstName, String lastName, String mobile, EGender gender, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.gender = gender;
        this.password = password;
    }
}
