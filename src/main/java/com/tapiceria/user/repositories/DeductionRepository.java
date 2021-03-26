package com.tapiceria.user.repositories;

import com.tapiceria.user.models.Deduction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeductionRepository extends CrudRepository<Deduction, Integer> {
    Iterable<Deduction> findAllByActiveTrue();
    Iterable<Deduction> findAllByActiveFalse();

    Optional<Deduction> findByIdAndActiveTrue(Integer id);
}
