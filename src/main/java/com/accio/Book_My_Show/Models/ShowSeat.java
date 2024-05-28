package com.accio.Book_My_Show.Models;

import com.accio.Book_My_Show.Enum.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    //we get seatNumber and seatType from theatre seat
    private String seatNumber;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private boolean isBooked;
    private boolean isFoodAttached;

    @JoinColumn
    @ManyToOne
    private Show show;


}
