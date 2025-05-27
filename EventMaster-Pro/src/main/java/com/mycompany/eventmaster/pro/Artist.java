package com.mycompany.eventmaster.pro;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String name;
    private String contactInfo;
    private String technicalRequirements;
    private List<String> pastEvents;

    public Artist(String name, String contactInfo, String technicalRequirements) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.technicalRequirements = technicalRequirements;
        this.pastEvents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getTechnicalRequirements() {
        return technicalRequirements;
    }

    public List<String> getPastEvents() {
        return pastEvents;
    }

    public void addPastEvent(String event) {
        pastEvents.add(event);
    }

    @Override
    public String toString() {
        return name + " | " + contactInfo + " | " + technicalRequirements + " | Past: " + pastEvents;
    }
}
