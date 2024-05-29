package com.accio.Book_My_Show.Services;

import com.accio.Book_My_Show.Models.*;
import com.accio.Book_My_Show.Repositories.*;
import com.accio.Book_My_Show.Requests.AddShowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;


    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    public String addShow(AddShowRequest addShowRequest){

        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());
        Theatre theatre = theatreRepository.findById(addShowRequest.getTheatreId()).get();

//        if you want add validations add validations to movie and theatre
        Show show = Show.builder().showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .theatre(theatre).movie(movie).build();

        show = showRepository.save(show);

        //Associate corresponding seats with it

        List<TheatreSeat> theatreSeatList1 = theatre.getTheatreSeatList();

        //List to store theatre seats

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheatreSeat theatreSeat:theatreSeatList1){
            ShowSeat showSeat = ShowSeat.builder().seatNumber(theatreSeat.getSeatNo())
                    .seatType(theatreSeat.getSeatType())
                    .isBooked(Boolean.FALSE)
                    .isFoodAttached(Boolean.FALSE)
                    .show(show)
                    .build();
            showSeatList.add(showSeat);
        }


        //Setting bidirectional mapping
        show.setShowSeatList(showSeatList);


        showSeatRepository.saveAll(showSeatList);

        return "show has been added successfully with show id "+show.getShowId();

    }
}
