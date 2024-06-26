package com.accio.Book_My_Show.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie_show")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;
    private LocalDate showDate;
    private LocalTime showTime;

    @JoinColumn
    @ManyToOne
    private Theatre theatre;

    @JoinColumn
    @ManyToOne
    private Movie movie;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList = new ArrayList<>();

}
