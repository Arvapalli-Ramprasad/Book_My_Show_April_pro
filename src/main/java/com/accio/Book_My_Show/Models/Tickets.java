package com.accio.Book_My_Show.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ticketId;
    private String bookedTickets;
    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private String theatreName;
    private Integer totalAmount;

    @JoinColumn
    @ManyToOne
    private User user;

    @JoinColumn
    @ManyToOne
    private Show show;
}
