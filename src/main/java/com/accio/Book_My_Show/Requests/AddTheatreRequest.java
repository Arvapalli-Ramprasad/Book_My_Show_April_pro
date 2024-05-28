package com.accio.Book_My_Show.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTheatreRequest {
    private String theatreName;
    private String theatreAdress;
    private Integer noOfScreens;
}
