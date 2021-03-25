package com.tapiceria.partida.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class RawMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String measureUnit;

    @Column(nullable = false)
    private Float cost;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String supplier;

    @Column(nullable = false)
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "departure_id")
    private Departure departure;
}
