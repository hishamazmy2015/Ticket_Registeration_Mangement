package com.programming.techie.springredditclone.controller;

import com.programming.techie.springredditclone.dto.UpdateUserName;
import com.programming.techie.springredditclone.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PutMapping("/api/user/edit-firstName")
    public ResponseEntity<String> getAllUsers(@RequestBody() UpdateUserName firstName) {

        userService.editUser(firstName.getFirstName());
        return status(HttpStatus.OK).body("FirstName has updated Successfully.");
    }


}
