package com.tapiceria.security;

import com.tapiceria.user.models.User;
import com.tapiceria.user.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class MyUserDetailsService  implements UserDetailsService {
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameAndActiveTrue(s)
                .orElseThrow(() -> new EntityNotFoundException("Role was not found."));
        return new MyUserDetails(user);
    }
}
