package com.javaunit3.springmvc;

import com.fasterxml.jackson.databind.deser.impl.PropertyValueBuffer;
import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
    public String getVoteBestMovieForm () {
        
        return "voteForBestMovie";
    }
    
    @GetMapping("/voteForBestMovie")
    public String getVoteBestMovie (HttpServletRequest request, Model model) {

        String movieTitle = request.getParameter("movieTitle");

        model.addAttribute(movieTitle);

        return "voteForBestMovie";
    }

}
