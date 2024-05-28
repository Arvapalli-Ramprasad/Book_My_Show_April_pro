package com.accio.Book_My_Show.Requests;

import lombok.Data;

@Data
public class AddTheatreSeatRequest {  //DTOS Are Custom Classes that helps to take Input from Clients
    private Integer theatreId;
    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;
}