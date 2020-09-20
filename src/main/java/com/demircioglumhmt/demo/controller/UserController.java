package com.demircioglumhmt.demo.controller;

import com.demircioglumhmt.demo.exception.ResourceNotFoundException;
import com.demircioglumhmt.demo.model.User;
import com.demircioglumhmt.demo.repository.UserRepository;
import com.demircioglumhmt.demo.security.CurrentUser;
import com.demircioglumhmt.demo.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return (User) userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
