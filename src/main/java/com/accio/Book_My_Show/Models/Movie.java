package com.accio.Book_My_Show.Models;

import com.accio.Book_My_Show.Enum.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    @Column(unique = true)
    private String movieName;
    private Double duration;
    private Double rating;
    @Enumerated(value = EnumType.STRING)
    private Language language;
    private LocalDate localDate;
}
