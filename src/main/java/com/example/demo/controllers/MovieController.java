package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;

//This is a bean - it is handled by the Spring framework
@Controller
public class MovieController {
    MovieAnalysisService movieService = new MovieAnalysisService();

    @ResponseBody
    @GetMapping("/")
    public String helloWorld() {
        return "<h1>Welcome to the page</h1><br><h2>You are a nice person!</h2>" +
                "<br><span id=\"box\"><a href=\"/getFirst\">Get First Movie</a>\n" +
                "  </span>" +
                "<br><span id=\"box\"><a href=\"/getRandom\">Get Random Movie</a>\n" + " </span>"
                + "<br><span id=\"box\"><a href=\"/getTenSortByPopularity\">Get 10 movies sorted by popularity</a>\n" + " </span>"
                + "<br><span id=\"box\"><a href=\"/howManyWonAnAward\">Number of movies which won an award</a>\n" + " </span>";

    }

    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst() throws FileNotFoundException {
        return "Movie title:" + movieService.getFirstMovieOfList().getTitle()
                +"<br><br><span id=\"box\"><a href=\"/\">Return home</a>\n" +" </span>";
    }


    @ResponseBody
    @GetMapping("/getRandom")
    public String getRandom() {
        return movieService.getRandomMovieOfList().getTitle()
                +"<br><br><span id=\"box\"><a href=\"/\">Return home</a>\n" +" </span>";
    }

    @ResponseBody
    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPop() {

        return movieService.getTenSortByPopularity()
                +"<br><br><span id=\"box\"><a href=\"/\">Return home</a>\n" +" </span>";
    }

    @ResponseBody
    @GetMapping("/howManyWonAnAward")
    public String getHowManyWonAnAward() {
        return String.valueOf(movieService.howManyWonAnAward())
                +"<br><br><span id=\"box\"><a href=\"/\">Return home</a>\n" +" </span>";
    }


}
