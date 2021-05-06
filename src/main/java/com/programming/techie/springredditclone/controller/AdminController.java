package com.programming.techie.springredditclone.controller;

import com.programming.techie.springredditclone.dto.TicketRequest;
import com.programming.techie.springredditclone.exceptions.CustomException;
import com.programming.techie.springredditclone.model.Ticket;
import com.programming.techie.springredditclone.model.User;
import com.programming.techie.springredditclone.model.VerificationToken;
import com.programming.techie.springredditclone.repository.VerificationTokenRepository;
import com.programming.techie.springredditclone.security.JwtProvider;
import com.programming.techie.springredditclone.service.TicketService;
import com.programming.techie.springredditclone.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@AllArgsConstructor
public class AdminController {

    private final UserService userService;
    private final TicketService ticketService;
    private final VerificationTokenRepository verificationTokenRepository;
    private final UserDetailsService userDetailsService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("/api/users/list")
    public ResponseEntity<List<User>> getAllUsers(@RequestHeader(name = "token") String token) {
        try {
            getAuthorization(token);
            return status(HttpStatus.OK).body(userService.getAllUsers());
        } catch (Exception e) {

            return status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @GetMapping("/api/tickets/list")
    public ResponseEntity<List<Ticket>> getAllTicket(@RequestHeader(name = "token") String token) {
        try {
            getAuthorization(token);
            return status(HttpStatus.OK).body(ticketService.getAllTickets());
        } catch (Exception e) {
            return status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @PostMapping("/api/tickets/add")
    public ResponseEntity<String> getAllTicket(@RequestHeader(name = "token") String token, @RequestBody TicketRequest ticket) {
        try {
            getAuthorization(token);
            ticketService.saveTicket(ticket.getMessage());
            return status(HttpStatus.OK).body("Ticket has saved Successfully ");
        } catch (Exception e) {
            return status(HttpStatus.FORBIDDEN).body(null);
        }

    }

    /*
     *
     *
     *
     *
     *
     *
     *
     *
     * */

    public void getAuthorization(String token) {
        String username = jwtProvider.getUsernameFromJwt(token);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}

/*
 *
 *
 *
 *
 * */



