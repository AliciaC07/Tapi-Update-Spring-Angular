package com.tapiceria.user.services;

import com.tapiceria.user.models.Role;
import com.tapiceria.user.models.User;
import com.tapiceria.user.repositories.DeductionRepository;
import com.tapiceria.user.repositories.RoleRepository;
import com.tapiceria.user.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final DeductionRepository deductionRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, DeductionRepository deductionRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.deductionRepository = deductionRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Iterable<User> findAll(){
        return userRepository.findAllByActiveTrue();
    }

    public User findByUsername(String username){
        return userRepository.findByUsernameAndActiveTrue(username)
            .orElseThrow(() -> new EntityNotFoundException("User was not found."));
    }

    public User findById(Integer id){
        return userRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EntityNotFoundException("User was not found."));
    }

    @Transactional
    public User save(User user){
        Role role = roleRepository.findByNameAndActiveTrue(user.getRole().getName())
                .orElseThrow(() -> new EntityNotFoundException("Role was not found."));
        user.setRole(role);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public User update(User user){
        deductionRepository.saveAll(user.getDeductions());
        return userRepository.save(user);
    }

    @Transactional
    public User delete(User user){
        user.setActive(false);
        return userRepository.save(user);
    }

}
