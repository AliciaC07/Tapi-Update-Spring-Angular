package com.tapiceria.partida.repository;

import com.tapiceria.partida.models.RawMaterial;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RawMaterialRepository extends CrudRepository<RawMaterial, Integer> {
    Optional<RawMaterial> findByNameIgnoreCaseAndActiveTrue(String name);
    Optional<RawMaterial> findByIdAndActiveTrue(Integer id);
    Iterable<RawMaterial> findAllByActiveTrue();

}
