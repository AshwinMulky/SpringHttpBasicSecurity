package com.ashwinmulky.spring.security.service;

import com.ashwinmulky.spring.security.model.User;
import com.ashwinmulky.spring.security.model.UserDetails;
import com.ashwinmulky.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> mayBeUser = userRepository.findByName(name);
        return mayBeUser.map(user -> new UserDetails(user))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
