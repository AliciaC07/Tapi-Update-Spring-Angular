package com.tapiceria.partida.repository;

import com.tapiceria.partida.models.Departure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartureRepository extends CrudRepository<Departure, Integer> {
    Iterable<Departure> findAllByActiveTrue();
    Optional<Departure> findByNameIgnoreCaseAndActiveTrue(String name);
    Optional<Departure> findByIdAndActiveTrue(Integer id);

}
