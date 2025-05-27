/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmaster.pro;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Desarrolladores:
 *         - Isabella Gómez Parra.
 *         - Daniel Eduardo González Palacio.
 */

public class EventMasterSystem {
    private ArrayList<EventBase> events;
    private ArrayList<Location> locations;
    private ArrayList<Artist> artists;
    private ArrayList<Ticket> tickets;
    private ArrayList<Sale> sales;
    private HashMap<EventBase, ArrayList<Sale>> eventSales;
    private AccessControl accessControl;
    private Finance finance;

    public EventMasterSystem() {
        events = new ArrayList<>();
        locations = new ArrayList<>();
        artists = new ArrayList<>();
        tickets = new ArrayList<>();
        sales = new ArrayList<>();
        eventSales = new HashMap<>();
        accessControl = new AccessControl();
        finance = new Finance(0);
    }

    // Events
    public void createEvent(EventBase event) {
        events.add(event);
    }

    public void modifyEvent(String eventName, String newDate, String newTime, Location newLocation, double newBudget) {
        for (EventBase event : events) {
            if (event.getName().equalsIgnoreCase(eventName)) {
                event.date = newDate;
                event.time = newTime;
                event.location = newLocation;
                event.budget = newBudget;
            }
        }
    }

    public void deleteEvent(String eventName) {
        events.removeIf(e -> e.getName().equalsIgnoreCase(eventName));
    }

    public ArrayList<EventBase> getEvents() {
        return events;
    }

    // Locations
    public void registerLocation(Location location) {
        locations.add(location);
    }

    public void deleteLocation(String locationName) {
        locations.removeIf(l -> l.getName().equalsIgnoreCase(locationName));
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    // Artists
    public void registerArtist(Artist artist) {
        artists.add(artist);
    }

    public void addPastEventToArtist(String artistName, String pastEvent) {
        for (Artist artist : artists) {
            if (artist.getName().equalsIgnoreCase(artistName)) {
                artist.addPastEvent(pastEvent);
            }
        }
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    // Tickets and Sales
    public void registerTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void registerSale(EventBase event, Sale sale) {
        sales.add(sale);
        finance.addIncome(sale.getTicket().getPrice());

        eventSales.putIfAbsent(event, new ArrayList<>());
        eventSales.get(event).add(sale);
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public ArrayList<Sale> getSalesByEvent(EventBase event) {
        return eventSales.getOrDefault(event, new ArrayList<>());
    }

    // Access Control
    public boolean validateAccessCode(String code) {
        return accessControl.validateTicket(code);
    }

    public int getTotalAttendees() {
        return accessControl.getTotalAttendees();
    }

    // Finance
    public Finance getFinance() {
        return finance;
    }

    public void setTotalBudget(double budget) {
        finance = new Finance(budget);
    }
}
