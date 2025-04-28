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

public class Location {
    private String name;
    private int capacity;
    private String technicalDetails;
    private ArrayList<String> availableDates;

    public Location(String name, int capacity, String technicalDetails) {
        this.name = name;
        this.capacity = capacity;
        this.technicalDetails = technicalDetails;
        this.availableDates = new ArrayList<>();
    }

    public void addAvailableDate(String date) {
        availableDates.add(date);
    }

    public boolean isAvailable(String date) {
        return availableDates.contains(date);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Location: " + name + " | Capacity: " + capacity + " | Technical details: " + technicalDetails;
    }
}
