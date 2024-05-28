package com.accio.Book_My_Show.Services;

import com.accio.Book_My_Show.Models.Movie;
import com.accio.Book_My_Show.Repositories.MovieRepository;
import com.accio.Book_My_Show.Requests.AddMovieRequest;
import com.accio.Book_My_Show.Requests.UpdateMovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(AddMovieRequest addMovieRequest){

       Movie movie = new Movie();
       movie.setMovieName(addMovieRequest.getMovieName());
       movie.setLanguage(addMovieRequest.getLanguage());
       movie.setDuration(addMovieRequest.getDuration());
       movie.setRating(addMovieRequest.getRating());
       movie.setLocalDate(addMovieRequest.getLocalDate());

       movie = movieRepository.save(movie);
       return "Movie Added Successfully With MivieId "+movie.getMovieId();
    }
    public String updateMovie(UpdateMovieRequest updateMovieRequest){
        Movie movie =movieRepository.findMovieByMovieName(updateMovieRequest.getNewMovieName());

        movie.setLanguage(updateMovieRequest.getNewLanguage());
        movie.setRating(updateMovieRequest.getNewRating());

        movie = movieRepository.save(movie);

        return "Movie attributes Updated Successfully with movie name "+movie.getMovieName();
    }
}
