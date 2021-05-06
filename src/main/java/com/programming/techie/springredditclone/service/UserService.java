package com.programming.techie.springredditclone.service;


import com.programming.techie.springredditclone.model.Ticket;
import com.programming.techie.springredditclone.model.User;
import com.programming.techie.springredditclone.repository.TicketRepository;
import com.programming.techie.springredditclone.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final AuthService authService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Transactional
    public void editUser(String firstName) {
        User currentUser = authService.getCurrentUser();
        currentUser.setFirstName(firstName);
        userRepository.save(currentUser);
    }


}

