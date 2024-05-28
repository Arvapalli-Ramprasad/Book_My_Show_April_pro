package com.accio.Book_My_Show.Services;

import com.accio.Book_My_Show.Enum.SeatType;
import com.accio.Book_My_Show.Models.ShowSeat;
import com.accio.Book_My_Show.Models.Theatre;
import com.accio.Book_My_Show.Models.TheatreSeat;
import com.accio.Book_My_Show.Repositories.ShowRepository;
import com.accio.Book_My_Show.Repositories.ShowSeatRepository;
import com.accio.Book_My_Show.Repositories.TheatreRepository;
import com.accio.Book_My_Show.Repositories.TheatreSeatRepository;
import com.accio.Book_My_Show.Requests.AddTheatreRequest;
import com.accio.Book_My_Show.Requests.AddTheatreSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private TheatreSeatRepository theatreSeatRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private ShowRepository showRepository;
    public String addTheatre(AddTheatreRequest addTheatreRequest){
        Theatre theatre = Theatre.builder().theatreName(addTheatreRequest.getTheatreName())
                .noOfScreens(addTheatreRequest.getNoOfScreens())
                .theatreAdress(addTheatreRequest.getTheatreAdress())
                .build();

        theatre = theatreRepository.save(theatre);
        return "Theatre has been saved successfully witn theatreId "+theatre.getTheatreId();
    }

    public String associateSeatAndTheatre(AddTheatreSeatRequest addTheatreSeatRequest){
        Integer theatreId = addTheatreSeatRequest.getTheatreId();
        Integer noOfClassicSeats = addTheatreSeatRequest.getNoOfClassicSeats();
        Integer noOfPremiumSeats = addTheatreSeatRequest.getNoOfPremiumSeats();

        //1) Get Theatre entity
        Theatre theatre = theatreRepository.findById(theatreId).get();
        List<TheatreSeat> theatreSeatList = new ArrayList<>();

        //2) Generate Seats using for loop
        Integer noOfRowsOfClassicSeats = noOfClassicSeats/5;
        Integer noOfSeatsInLastRow = noOfClassicSeats%5;

        int row;
        for(row =1;row<=noOfRowsOfClassicSeats;row++){
            for(int j = 1;j<=5;j++){
                char ch = (char)('A'+j-1);
                String seatNo = ""+row+ch;


                TheatreSeat theatreSeat = TheatreSeat.builder().seatNo(seatNo)
                        .seatType(SeatType.CLASSIC)
                        .theatre(theatre)
                        .build();
                theatreSeatList.add(theatreSeat);
            }
        }
        //for last row
        for(int j = 1;j<=noOfSeatsInLastRow;j++){
            char ch = (char)('A'+j-1);
            String seatNo = ""+row+ch;
            TheatreSeat theatreSeat = TheatreSeat.builder().seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theatre(theatre)
                    .build();
            theatreSeatList.add(theatreSeat);
        }

        //Same Logic for Premium seats
        Integer noOfRowsOfPremiumSeats = noOfPremiumSeats/5;
        Integer noOfPremuimSeatsInLastRow = noOfPremiumSeats%5;

        int currRow = row;
        if(noOfSeatsInLastRow>0){
            currRow++;
        }
        for(row =currRow;row<noOfRowsOfPremiumSeats+currRow;row++){
            for(int j = 1;j<=5;j++){
                char ch = (char)('A'+j-1);
                String seatNo = ""+row+ch;


                TheatreSeat theatreSeat = TheatreSeat.builder().seatNo(seatNo)
                        .seatType(SeatType.PREMIUM)
                        .theatre(theatre)
                        .build();
                theatreSeatList.add(theatreSeat);
            }
        }
        //for last row
        for(int j = 1;j<=noOfPremuimSeatsInLastRow;j++){
            char ch = (char)('A'+j-1);
            String seatNo = ""+row+ch;
            TheatreSeat theatreSeat = TheatreSeat.builder().seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theatre(theatre)
                    .build();
            theatreSeatList.add(theatreSeat);
        }

        theatreSeatRepository.saveAll(theatreSeatList);


        //save all generated seats into theatre DB
        theatre.setTheatreSeatList(theatreSeatList);
        theatreRepository.save(theatre);

        return "Theatre Seats Have Been Associated";

    }
}
