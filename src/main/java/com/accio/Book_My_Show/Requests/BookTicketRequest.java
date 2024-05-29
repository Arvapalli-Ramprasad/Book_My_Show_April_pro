package com.accio.Book_My_Show.Requests;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class BookTicketRequest {
//    private String movieName;
//    private Integer theatreId;
//    private LocalDate showDate;
//    private LocalTime showTime;

    private List<String> requestedSeats;
    private Integer showId;
    private Integer userId;

}
