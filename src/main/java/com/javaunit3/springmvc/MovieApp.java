package com.javaunit3.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@ComponentScan

public class MovieApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MovieApp.class);

        BestMovieService bestMovieService = applicationContext.getBean(BestMovieService.class);

        Movie bestMovie = bestMovieService.getBestMovie();

        System.out.println(bestMovie.getTitle());
        System.out.println(bestMovie.getGenre());
        System.out.println(bestMovie.getMaturityRating());
    }

}
