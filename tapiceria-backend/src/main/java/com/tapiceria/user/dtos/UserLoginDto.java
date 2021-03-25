package com.tapiceria.user.dtos;

import com.tapiceria.user.models.Deduction;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginDto {

    private Integer id;

    private String name;

    private String lastname;

    private String username;

    private String email;

    private String phone;


    private String address;

    private String workStation;


    private String departament;


    private Float baseSalary;


    private Float taxes;


    private List<DeductionDto> deductions;


    private RoleDto role;

    private String token;

    private String type = "Bearer";
}
