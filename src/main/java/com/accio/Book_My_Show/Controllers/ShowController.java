package com.accio.Book_My_Show.Controllers;

import com.accio.Book_My_Show.Requests.AddShowRequest;
import com.accio.Book_My_Show.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    private ShowService showService;
    @PostMapping("add")
    public ResponseEntity addShow(@RequestBody AddShowRequest addShowRequest){
        String response = showService.addShow(addShowRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
