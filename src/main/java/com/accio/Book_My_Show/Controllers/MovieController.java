package com.accio.Book_My_Show.Controllers;

import com.accio.Book_My_Show.Requests.AddMovieRequest;
import com.accio.Book_My_Show.Requests.UpdateMovieRequest;
import com.accio.Book_My_Show.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("add")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest addMovieRequest){
        String response = movieService.addMovie(addMovieRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateMovie(@RequestBody UpdateMovieRequest updateMovieRequest){
        String result = movieService.updateMovie(updateMovieRequest);
        return new ResponseEntity(result,HttpStatus.OK);
    }
}
