package com.tapiceria.partida.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Departure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "departure")
    private List<RawMaterial> rawMaterials;

    @OneToMany(mappedBy = "departure")
    private List<IndirectCost> indirectCosts;

    @JsonIgnore
    @Column(nullable = false)
    private Boolean active = true;

    @OneToOne
    @JoinColumn(name = "direct_cost_id", updatable = false, nullable = false)
    private DirectCost directCosts;

}
