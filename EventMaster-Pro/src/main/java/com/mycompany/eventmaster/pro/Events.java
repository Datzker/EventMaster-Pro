/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmaster.pro;

import java.util.ArrayList;

/**
 * Desarrolladores:
 *         - Isabella Gómez Parra.
 *         - Daniel Eduardo González Palacio.
 */

public class Events {
    private String name;
    private String date;
    private String time;
    private Location location;
    private String category;
    private double budget;
    private ArrayList<Artist> artists;

    public Events(String name, String date, String time, Location location, String category, double budget) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.category = category;
        this.budget = budget;
        this.artists = new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Event: " + name + " | Date: " + date + " | Time: " + time +
                " | Category: " + category + " | Location: " + location.getName() +
                " | Budget: $" + budget;
    }
}
