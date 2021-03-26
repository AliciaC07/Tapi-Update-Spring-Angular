package com.tapiceria.user.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class DeductionDto {

    private Integer id;


    private String description;


    private Float spending;


    private LocalDate date;
}
