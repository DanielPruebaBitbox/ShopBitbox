package com.example.shop.shopproject.controller;

import java.util.List;

import com.example.shop.shopproject.Service.UserService;
import com.example.shop.shopproject.model.User;
import com.example.shop.shopproject.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public  ResponseEntity<List<User>> getAllUsers(){
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);    }

    @GetMapping("/user/{id}")
    public ResponseEntity <User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {

        User user = userService.getUserById(userId);
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping("/users")
    public ResponseEntity <User> createUser(@RequestBody User user) throws ResourceNotFoundException {
        User newUser = userService.createOrUpdateUser(user, 0);
        return new ResponseEntity<User>(newUser, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity <User> updateUser(@RequestBody User user, @PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User updatedUser = userService.createOrUpdateUser(user, userId);
        return new ResponseEntity<User>(updatedUser, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public HttpStatus deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        userService.deleteUser(userId);
        return HttpStatus.FORBIDDEN;
    }

}
