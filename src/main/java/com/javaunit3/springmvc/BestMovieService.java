package com.javaunit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component
public class BestMovieService {
    private Movie movie;

    @Autowired
    public BestMovieService(@Qualifier("titanicMovie")Movie movie) {
        this.movie = movie;
    }

    public Movie getBestMovie() {
        return movie;
    }

}
