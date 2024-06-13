package com.example.vet_cristo.service.impl;

import com.example.vet_cristo.model.Rol;
import com.example.vet_cristo.model.Users;
import com.example.vet_cristo.repository.RolRepository;
import com.example.vet_cristo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RolRepository rolRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, RolRepository rolRepository) {
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        Users userDetails = user.get();
        Collection<? extends GrantedAuthority> authorities = getAuthorities(userDetails.getRoleId());
        log.info("Roles del usuario {}: {}", userDetails.getEmail(), authorities);
        return new org.springframework.security.core.userdetails.User(
                userDetails.getEmail(), userDetails.getPassword(), authorities);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String roleId) {
        Optional<Rol> optionalRol = rolRepository.findById(roleId);
        if (!optionalRol.isPresent()) {
            throw new IllegalArgumentException("Rol no encontrado para el ID proporcionado");
        }

        Rol rol = optionalRol.get();
        String roleName = "ROLE_" + rol.getName().toUpperCase();
        log.info("Rol encontrado: {}", roleName);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roleName));
        return authorities;
    }
}
