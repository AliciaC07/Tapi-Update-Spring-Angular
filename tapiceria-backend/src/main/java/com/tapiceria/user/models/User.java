package com.tapiceria.user.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @Column(nullable = false,  length = 50)
    private String name;

    @Column(nullable = false,  length = 50)
    private String lastName;

    @Column(nullable = false,  length = 100)
    private String password;

    @Column(nullable = false, unique = true ,length = 20)
    private String phone;

    @Column(nullable = false,  length = 100)
    private String address;

    @Column(nullable = false,  length = 100, unique = true)
    private String email;

    @Column(nullable = false,  length = 50)
    private String workStation;

    @Column(nullable = false,  length = 50)
    private String departament;

    @Column(nullable = false)
    private Float baseSalary;

    @Column(nullable = false)
    private Float taxes;

    @OneToMany(mappedBy = "employee")
    private List<Deduction> deductions;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @JsonIgnore
    @Column(nullable = false)
    private Boolean active = true;



}
