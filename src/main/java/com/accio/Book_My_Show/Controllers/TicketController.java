package com.accio.Book_My_Show.Controllers;

import com.accio.Book_My_Show.Models.Tickets;
import com.accio.Book_My_Show.Requests.BookTicketRequest;
import com.accio.Book_My_Show.Response.TicketResponse;
import com.accio.Book_My_Show.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @PostMapping("bookTicket")
    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest){
        return ticketService.bookTicket(bookTicketRequest);
    }

    @GetMapping("generateTicket")
    public TicketResponse generateTickets(@RequestParam("ticketId") String ticketId){
        return ticketService.generateTicket(ticketId);
    }
}
