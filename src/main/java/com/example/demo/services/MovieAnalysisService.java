package com.example.demo.services;

import com.example.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MovieAnalysisService{

    private ArrayList<Movie> listOfMovies;


    public MovieAnalysisService() {
        listOfMovies = new ArrayList();
        createListOfMovies();
    }

    public void createListOfMovies() {
        //Instantiated a file from film-new.csv
        File movieList = new File("src/main/resources/static/film-new.csv");
        //Scanner
        try {
            Scanner sc = new Scanner(movieList);

            sc.nextLine();
            sc.nextLine();

            while(sc.hasNextLine())
                {
                String[] movieInformation = (sc.nextLine().split(";"));
                Movie tmp = new Movie(movieInformation);
                listOfMovies.add(tmp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

    }

    public Movie getFirstMovieOfList() throws FileNotFoundException {
        return listOfMovies.get(0);
    }

    public Movie getRandomMovieOfList() {
        Random r = new Random();
        int movieNr = r.nextInt(listOfMovies.size());
        return listOfMovies.get(movieNr);
    }

    public String getTenSortByPopularity() {
        ArrayList<Movie> tenRandomMovies = new ArrayList();
        Random r = new Random();

        while(tenRandomMovies.size()<10){
            int number = r.nextInt(listOfMovies.size());

            if(!(tenRandomMovies.contains(listOfMovies.get(number)))){
                tenRandomMovies.add(listOfMovies.get(number));
            }
        }

        Collections.sort(tenRandomMovies);

        String movies ="";
        for(int i=0;i<tenRandomMovies.size();i++){
            movies+=tenRandomMovies.get(i).getTitle()+", Score: "+tenRandomMovies.get(i).getPopularity()+"<br>";
        }
        return movies;
    }

    public int howManyWonAnAward() {
        int counter = 0;
        for (int i = 0; i < listOfMovies.size(); i++) {
            if(listOfMovies.get(i).getAward()==true){
                counter++;
            }
        }
        return counter;
    }

}
