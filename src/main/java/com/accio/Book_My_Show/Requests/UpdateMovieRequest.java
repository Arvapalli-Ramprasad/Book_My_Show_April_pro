package com.accio.Book_My_Show.Requests;

import com.accio.Book_My_Show.Enum.Language;
import lombok.Data;

@Data
public class UpdateMovieRequest {
    private String newMovieName;
    private Language newLanguage;
    private Double newRating;
}
