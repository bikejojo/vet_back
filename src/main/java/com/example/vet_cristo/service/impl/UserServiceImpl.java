package com.example.vet_cristo.service.impl;
import com.example.vet_cristo.model.Pet;
import com.example.vet_cristo.model.Rol;
import com.example.vet_cristo.model.Users;
import com.example.vet_cristo.repository.RolRepository;
import com.example.vet_cristo.repository.UserRepository;
import com.example.vet_cristo.service.UserService;
import com.example.vet_cristo.service.dto.UserRequest;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users createUser(UserRequest userRequest) {
        Rol role = roleRepository.findById(userRequest.getRoleId())
                .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado"));

        String encryptedPassword = passwordEncoder.encode(userRequest.getPassword());

        Users newUser = new Users();
        newUser.setNames(userRequest.getNames());
        newUser.setLastNames(userRequest.getLastNames());
        newUser.setCi(userRequest.getCi());
        newUser.setPhone(userRequest.getPhone());
        newUser.setAddress(userRequest.getAddress());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(encryptedPassword);
        newUser.setRoleId(userRequest.getRoleId());

        return userRepository.save(newUser);
    }

    @Override
    public Users updateUser(String id, Users user) {
        Optional<Users> existingUsersOptional = userRepository.findById(id);
        if (user != null && existingUsersOptional.isPresent()) {
            Users existingUsers = existingUsersOptional.get();
            existingUsers.setNames(user.getNames());
            existingUsers.setLastNames(user.getLastNames());
            existingUsers.setCi(user.getCi());
            existingUsers.setPhone(user.getPhone());
            existingUsers.setEmail(user.getEmail());
            return userRepository.save(existingUsers);
        }
        else {
            throw new RuntimeException("Users no encontrado con ID: " + id);
        }
    }

    @Override
    public void deleteUser(String id) {
        Optional<Users> existingUsersOptional = userRepository.findById(id);
        if (existingUsersOptional.isPresent()) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public Optional<Users> getUserById(String id) {
        return userRepository.findById(id);
    }

}
