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

public class Artist {
    private String name;
    private String contactInfo;
    private String technicalRequirements;
    private ArrayList<String> pastEvents;

    public Artist(String name, String contactInfo, String technicalRequirements) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.technicalRequirements = technicalRequirements;
        this.pastEvents = new ArrayList<>();
    }

    public void addPastEvent(String event) {
        pastEvents.add(event);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPastEvents() {
        return pastEvents;
    }

    @Override
    public String toString() {
        return "Artist: " + name + " | Contact: " + contactInfo + " | Technical requirements: " + technicalRequirements +
               " | Past Events: " + pastEvents.toString();
    }
}
