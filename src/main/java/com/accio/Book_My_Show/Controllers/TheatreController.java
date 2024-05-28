package com.accio.Book_My_Show.Controllers;

import com.accio.Book_My_Show.Requests.AddTheatreRequest;
import com.accio.Book_My_Show.Requests.AddTheatreSeatRequest;
import com.accio.Book_My_Show.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theatre")
public class TheatreController{
    @Autowired
    private TheatreService theatreService;
    @PostMapping("add")
    public ResponseEntity addTheatre(@RequestBody  AddTheatreRequest addTheatreRequest){
        String response  = theatreService.addTheatre(addTheatreRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("associateSeatAndTheatre")
    public ResponseEntity associateSeatAndTheatre(@RequestBody AddTheatreSeatRequest addTheatreSeatRequest){
        String response = theatreService.associateSeatAndTheatre(addTheatreSeatRequest);
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
