package com.devsuperior.movieflix.controllers;

import com.devsuperior.movieflix.dto.UserDTO;

import com.devsuperior.movieflix.services.AuthService;
import com.devsuperior.movieflix.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;


    @PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
    @GetMapping(value = "/profile")
    public ResponseEntity<UserDTO> getProfile() {
        UserDTO dto = userService.getProfile();
        return ResponseEntity.ok(dto);
    }

}
