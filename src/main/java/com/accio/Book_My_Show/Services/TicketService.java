package com.accio.Book_My_Show.Services;

import com.accio.Book_My_Show.Enum.SeatType;
import com.accio.Book_My_Show.Models.Show;
import com.accio.Book_My_Show.Models.ShowSeat;
import com.accio.Book_My_Show.Models.Tickets;
import com.accio.Book_My_Show.Models.User;
import com.accio.Book_My_Show.Repositories.ShowRepository;
import com.accio.Book_My_Show.Repositories.ShowSeatRepository;
import com.accio.Book_My_Show.Repositories.TicketRepository;
import com.accio.Book_My_Show.Repositories.UserRepository;
import com.accio.Book_My_Show.Requests.BookTicketRequest;
import com.accio.Book_My_Show.Response.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;
    public String bookTicket(BookTicketRequest bookTicketRequest){

        //Find show entity
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();

        //Find user Entity
        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        //Mark Those Tickets has booked and calculate amount

        Integer totalAmount=0;

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for(ShowSeat showSeat:showSeatList){
            String seatNumber = showSeat.getSeatNumber();

            if(bookTicketRequest.getRequestedSeats().contains(seatNumber)){
                showSeat.setBooked(Boolean.TRUE);
            }


            if(showSeat.getSeatType().equals(SeatType.CLASSIC)){
                totalAmount=totalAmount+10;
            }
            else{
                totalAmount=totalAmount+1;
            }
        }

        //Create the ticket entity and set the attributes

        Tickets ticket = Tickets.builder()
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .movieName(show.getMovie().getMovieName())
                .theatreName(show.getTheatre().getTheatreName())
                .totalAmount(totalAmount)
                .bookedTickets(bookTicketRequest.getRequestedSeats().toString())
                .user(user)
                .show(show)
                .build();

        showSeatRepository.saveAll(showSeatList);

        //Save the tickt into db and return ticket
        ticket = ticketRepository.save(ticket);

        return ticket.getTicketId();

    }

    public TicketResponse generateTicket(String ticketId){
        Tickets ticket = ticketRepository.findById(ticketId).get();

        //Entity has to be converted to TicketResponse

        TicketResponse ticketResponse = TicketResponse.builder()
                .bookedTickets(ticket.getBookedTickets())
                .showDate(ticket.getShowDate())
                .showTime(ticket.getShowTime())
                .movieName(ticket.getMovieName())
                .theatreName(ticket.getTheatreName())
                .totalAmount(ticket.getTotalAmount())
                .build();
        return  ticketResponse;
    }

}
