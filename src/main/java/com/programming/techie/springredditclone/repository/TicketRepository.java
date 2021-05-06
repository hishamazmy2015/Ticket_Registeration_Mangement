package com.programming.techie.springredditclone.repository;

import com.programming.techie.springredditclone.model.Ticket;
import com.programming.techie.springredditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
