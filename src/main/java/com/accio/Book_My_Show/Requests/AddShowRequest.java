package com.accio.Book_My_Show.Requests;

import com.accio.Book_My_Show.Enum.SeatType;
import com.accio.Book_My_Show.Models.Movie;
import com.accio.Book_My_Show.Models.Show;
import com.accio.Book_My_Show.Models.Theatre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddShowRequest {

    private LocalDate showDate;
    private LocalTime showTime;

    private Integer theatreId;
    private String movieName;

    private Show show;
}
