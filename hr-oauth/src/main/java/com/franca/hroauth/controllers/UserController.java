package com.franca.hroauth.controllers;

import com.franca.hroauth.entities.User;
import com.franca.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/oauth")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email);
        try {
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return (ResponseEntity<User>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

    }


}
