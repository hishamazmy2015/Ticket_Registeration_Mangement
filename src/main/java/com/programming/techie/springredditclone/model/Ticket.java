package com.programming.techie.springredditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Ticket {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long ticketId;
    private String userId;
    private String message;

    public Ticket(String userId, String message) {
        this.userId = userId;
        this.message = message;
    }
}
