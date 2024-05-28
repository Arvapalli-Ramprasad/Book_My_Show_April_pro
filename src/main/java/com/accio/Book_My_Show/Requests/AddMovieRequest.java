package com.accio.Book_My_Show.Requests;

import com.accio.Book_My_Show.Enum.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {
    private String movieName;
    private Double duration;
    private Double rating;
    private Language language;
    private LocalDate localDate;
}
