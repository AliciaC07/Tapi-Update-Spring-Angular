package com.tapiceria.user.repositories;


import com.tapiceria.user.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByNameAndActiveTrue(String name);
    Optional<Role> findByName(String name);

}
