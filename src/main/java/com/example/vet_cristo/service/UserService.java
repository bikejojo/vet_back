package com.example.vet_cristo.service;

import com.example.vet_cristo.model.Pet;
import com.example.vet_cristo.model.Rol;
import com.example.vet_cristo.model.Users;
import com.example.vet_cristo.service.dto.UserRequest;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService  {

    List<Users> getAllUsers();

    Users createUser(UserRequest userRequest);

    void deleteUser(String id);

    Users updateUser(String id, Users user);

    Optional<Users> getUserById(String id);


}
