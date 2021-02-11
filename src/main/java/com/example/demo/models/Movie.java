package com.example.demo.models;

public class Movie implements Comparable<Movie>{
    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean award;

    public Movie(String[] informationOfMovie) {
        this.year = Integer.parseInt(informationOfMovie[0]);
        this.length = Integer.parseInt(informationOfMovie[1]);
        this.title = informationOfMovie[2];
        this.subject = informationOfMovie[3];
        this.popularity = Integer.parseInt(informationOfMovie[4]);

        if (informationOfMovie[5].toLowerCase().equals("yes")) {
            this.award = true;
        } else {
            this.award = false;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getAward() {
        return award;
    }

    public int getPopularity() {
        return this.popularity;
    }


    public int compareTo(Movie o) {
        if (o.getPopularity() > this.popularity) {
            return 1;
        } else if (o.getPopularity() < this.popularity) {
            return -1;
        } else {
            return 0;
        }
    }


}
