package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MovieController {

    private BestMovieService bestMovieService;

    public MovieController(BestMovieService bestMovieService) {
        this.bestMovieService = bestMovieService;
    }

    @GetMapping("/")
    public String geIndexPage () {
        return "index";
    }

    @GetMapping("/bestMovie")
    public String getBestMoviePage(Model model) {

        model.addAttribute("BestMovie", bestMovieService.getBestMovie().getTitle());

        return "bestMovie";
    }
    @GetMapping("/voteForBestMovieForm")
    public String getVoteBestMovieFormPage (Model model) {

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        List<MovieEntity> movieEntityList = session.createQuery("from MovieEntity").list();

        session.getTransaction().commit();

        model.addAttribute("movies", movieEntityList);

        return "voteForBestMovie";
    }
    
    @GetMapping("/voteForBestMovie")
    public String getVoteBestMovie (HttpServletRequest request, Model model) {

        String movieTitle = request.getParameter("movieTitle");

        model.addAttribute(movieTitle);

        String movieId = request.getParameter("movieId");
        String voterName = request.getParameter("voterName");

        return "voteForBestMovie";
    }

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/addMovieForm")
    public String addMovieForm() {

        return "addMovie";
    }

    @RequestMapping(value = "/addMovie")
    public String addMovie(HttpServletRequest request) {

        String movieTitle = request.getParameter("movieTitle");
        String maturityRating = request.getParameter("maturityRating");
        String genre = request.getParameter("genre");

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movieTitle);
        movieEntity.setMaturityRating(maturityRating);
        movieEntity.setGenre(genre);

        return "addMovie";
    }
}
