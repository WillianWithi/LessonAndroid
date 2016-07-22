package com.example.willian.primeiroapp.Model;

/**
 * Created by willian on 22/07/16.
 */
public class Book {
    private String title, url;
    private int year;
    private double rating;

    public Book(){}

    public Book(String title, String url, int year, double rating){
        this.title = title;
        this.url = url;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
