package com.accio.Book_My_Show.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
    private String bookedTickets;
    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private String theatreName;
    private Integer totalAmount;
}
