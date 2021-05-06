package com.programming.techie.springredditclone.controller;

import com.programming.techie.springredditclone.model.User;
import com.programming.techie.springredditclone.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


//    @GetMapping("/api/user/edit")
//    public ResponseEntity<List<User>> getAllUsers() {
//        return status(HttpStatus.OK).body(userService.getAllUsers());
//    }


    @PutMapping("/api/user/edit-firstName")
    public ResponseEntity<String> getAllUsers(@RequestBody String firstName) {
        userService.editUser(firstName);
        return status(HttpStatus.OK).body("FirstName has updated Successfully.");
    }


}
