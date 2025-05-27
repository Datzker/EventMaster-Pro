package com.mycompany.eventmaster.pro;

import java.util.ArrayList;

/**
 * Desarrolladores:
 *         - Isabella Gómez Parra.
 *         - Daniel Eduardo González Palacio.
 */

public abstract class EventBase {
    protected String name;
    protected String date;
    protected String time;
    protected Location location;
    protected double budget;
    protected ArrayList<Artist> artists;

    public EventBase(String name, String date, String time, Location location, double budget) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.budget = budget;
        this.artists = new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
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

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public abstract String getCategory();

    public abstract String getFinancialInfo();
}
