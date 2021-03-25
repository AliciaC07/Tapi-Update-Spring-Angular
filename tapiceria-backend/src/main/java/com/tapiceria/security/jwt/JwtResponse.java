package com.tapiceria.security.jwt;

import com.tapiceria.user.models.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {

    private Integer id;

    private String token;

    private String username;

    private String name;

    private String lastName;

    private String email;

    private String departament;

    private Float baseSalary;

    private Role role;

    private String type = "Bearer";
}
