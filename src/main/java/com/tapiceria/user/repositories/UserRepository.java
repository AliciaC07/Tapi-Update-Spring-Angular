package com.tapiceria.user.repositories;

import com.tapiceria.user.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsernameAndActiveTrue(String name);
    Optional<User> findByIdAndActiveTrue(Integer id);

    Iterable<User> findAllByActiveTrue();
}
