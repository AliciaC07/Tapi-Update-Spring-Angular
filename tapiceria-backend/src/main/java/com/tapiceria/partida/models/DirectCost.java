package com.tapiceria.partida.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class DirectCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String workForce;

    @Column(nullable = false)
    private Float cost;

    @OneToOne(mappedBy = "directCosts", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Departure departure;

}
