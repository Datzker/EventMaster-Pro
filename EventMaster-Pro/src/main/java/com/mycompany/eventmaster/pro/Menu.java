/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmaster.pro;

import java.util.Scanner;

/**
 * Desarrolladores:
 *         - Isabella Gómez Parra.
 *         - Daniel Eduardo González Palacio.
 */

public class Menu {
    
    public static void showMainMenu(EventMasterSystem system) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- EventMaster Pro ---");
            System.out.println("1. Manage Events");
            System.out.println("2. Manage Locations");
            System.out.println("3. Manage Artists");
            System.out.println("4. Manage Tickets and Sales");
            System.out.println("5. Access Control");
            System.out.println("6. Finance Overview");
            System.out.println("7. View Events Calendar");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    manageEvents(system, scanner);
                    break;
                case 2:
                    manageLocations(system, scanner);
                    break;
                case 3:
                    manageArtists(system, scanner);
                    break;
                case 4:
                    manageTicketsAndSales(system, scanner);
                    break;
                case 5:
                    manageAccessControl(system, scanner);
                    break;
                case 6:
                    showFinance(system);
                    break;
                case 7:
                    showEventsCalendar(system);
                    break;
                case 0:
                    System.out.println("Thank you for using EventMaster Pro!");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (option != 0);
    }

    private static void manageEvents(EventMasterSystem system, Scanner scanner) {
        System.out.println("\n--- Manage Events ---");
        System.out.println("1. Create Event");
        System.out.println("2. Modify Event");
        System.out.println("3. Delete Event");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                createEvent(system, scanner);
                break;
            case 2:
                modifyEvent(system, scanner);
                break;
            case 3:
                deleteEvent(system, scanner);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void createEvent(EventMasterSystem system, Scanner scanner) {
        System.out.print("Event name: ");
        String name = scanner.nextLine();
        System.out.print("Event date (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.print("Event time (hh:mm): ");
        String time = scanner.nextLine();
        System.out.print("Event category: ");
        String category = scanner.nextLine();
        System.out.print("Event budget: ");
        double budget = scanner.nextDouble();
        scanner.nextLine();

        if (system.getLocations().isEmpty()) {
            System.out.println("No locations available. Please register one first.");
            return;
        }

        System.out.println("Available Locations:");
        for (Location loc : system.getLocations()) {
            System.out.println("- " + loc.getName());
        }
        System.out.print("Enter location name: ");
        String locationName = scanner.nextLine();
        Location selectedLocation = null;
        for (Location loc : system.getLocations()) {
            if (loc.getName().equalsIgnoreCase(locationName)) {
                selectedLocation = loc;
                break;
            }
        }

        if (selectedLocation == null) {
            System.out.println("Location not found.");
            return;
        }

        Events newEvent = new Events(name, date, time, selectedLocation, category, budget);
        system.createEvent(newEvent);
        System.out.println("Event created successfully!");
    }

    private static void modifyEvent(EventMasterSystem system, Scanner scanner) {
        if (system.getEvents().isEmpty()) {
            System.out.println("No events available to modify.");
            return;
        }

        System.out.println("Available Events:");
        for (Events event : system.getEvents()) {
            System.out.println("- " + event.getName());
        }
        System.out.print("Enter the event name to modify: ");
        String eventName = scanner.nextLine();

        System.out.print("New date (yyyy-mm-dd): ");
        String newDate = scanner.nextLine();
        System.out.print("New time (hh:mm): ");
        String newTime = scanner.nextLine();
        System.out.print("New category: ");
        String newCategory = scanner.nextLine();
        System.out.print("New budget: ");
        double newBudget = scanner.nextDouble();
        scanner.nextLine();

        if (system.getLocations().isEmpty()) {
            System.out.println("No locations available. Please register one first.");
            return;
        }

        System.out.println("Available Locations:");
        for (Location loc : system.getLocations()) {
            System.out.println("- " + loc.getName());
        }
        System.out.print("Enter new location name: ");
        String locationName = scanner.nextLine();
        Location selectedLocation = null;
        for (Location loc : system.getLocations()) {
            if (loc.getName().equalsIgnoreCase(locationName)) {
                selectedLocation = loc;
                break;
            }
        }

        if (selectedLocation == null) {
            System.out.println("Location not found.");
            return;
        }

        system.modifyEvent(eventName, newDate, newTime, newCategory, selectedLocation, newBudget);
        System.out.println("Event modified successfully!");
    }

    private static void deleteEvent(EventMasterSystem system, Scanner scanner) {
        if (system.getEvents().isEmpty()) {
            System.out.println("No events available to delete.");
            return;
        }

        System.out.println("Available Events:");
        for (Events event : system.getEvents()) {
            System.out.println("- " + event.getName());
        }
        System.out.print("Enter the event name to delete: ");
        String eventName = scanner.nextLine();

        system.deleteEvent(eventName);
        System.out.println("Event deleted successfully!");
    }

    private static void manageLocations(EventMasterSystem system, Scanner scanner) {
        System.out.println("\n--- Manage Locations ---");
        System.out.print("Location name: ");
        String name = scanner.nextLine();
        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Technical details: ");
        String technicalDetails = scanner.nextLine();

        Location location = new Location(name, capacity, technicalDetails);

        System.out.print("How many available dates?: ");
        int dateCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < dateCount; i++) {
            System.out.print("Enter available date (yyyy-mm-dd): ");
            String date = scanner.nextLine();
            location.addAvailableDate(date);
        }

        system.registerLocation(location);
        System.out.println("Location registered successfully!");
    }

    private static void manageArtists(EventMasterSystem system, Scanner scanner) {
        System.out.println("\n--- Manage Artists ---");
        System.out.println("1. Register New Artist");
        System.out.println("2. Add Past Event to Artist");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                registerArtist(system, scanner);
                break;
            case 2:
                addPastEventToArtist(system, scanner);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void registerArtist(EventMasterSystem system, Scanner scanner) {
        System.out.print("Artist name: ");
        String name = scanner.nextLine();
        System.out.print("Contact info: ");
        String contact = scanner.nextLine();
        System.out.print("Technical requirements: ");
        String techReq = scanner.nextLine();

        Artist artist = new Artist(name, contact, techReq);
        system.registerArtist(artist);
        System.out.println("Artist registered successfully!");
    }

    private static void addPastEventToArtist(EventMasterSystem system, Scanner scanner) {
        if (system.getArtists().isEmpty()) {
            System.out.println("No artists registered yet.");
            return;
        }

        System.out.println("Registered Artists:");
        for (Artist artist : system.getArtists()) {
            System.out.println("- " + artist.getName());
        }

        System.out.print("Enter artist name: ");
        String artistName = scanner.nextLine();
        System.out.print("Enter past event name: ");
        String pastEvent = scanner.nextLine();

        system.addPastEventToArtist(artistName, pastEvent);
        System.out.println("Past event added to artist history successfully!");
    }

    private static void manageTicketsAndSales(EventMasterSystem system, Scanner scanner) {
        System.out.println("\n--- Manage Tickets and Sales ---");
        System.out.print("Ticket type: ");
        String type = scanner.nextLine();
        System.out.print("Ticket price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Ticket ticket = new Ticket(type, price);
        system.registerTicket(ticket);
        System.out.println("Ticket registered successfully!");

        System.out.println("Do you want to sell a ticket now? (yes/no)");
        String sellNow = scanner.nextLine();
        if (sellNow.equalsIgnoreCase("yes")) {
            if (system.getEvents().isEmpty()) {
                System.out.println("No events available.");
                return;
            }

            System.out.println("Available Events:");
            for (Events event : system.getEvents()) {
                System.out.println("- " + event.getName());
            }
            System.out.print("Enter event name: ");
            String eventName = scanner.nextLine();
            Events selectedEvent = null;
            for (Events event : system.getEvents()) {
                if (event.getName().equalsIgnoreCase(eventName)) {
                    selectedEvent = event;
                    break;
                }
            }

            if (selectedEvent == null) {
                System.out.println("Event not found.");
                return;
            }

            System.out.print("Buyer name: ");
            String buyerName = scanner.nextLine();
            System.out.print("Purchase date (yyyy-mm-dd): ");
            String purchaseDate = scanner.nextLine();

            Sale sale = new Sale(ticket, buyerName, purchaseDate);
            system.registerSale(selectedEvent, sale);
            System.out.println("Sale registered successfully!");
        }
    }

    private static void manageAccessControl(EventMasterSystem system, Scanner scanner) {
        System.out.println("\n--- Access Control ---");
        System.out.print("Enter access code to validate: ");
        String code = scanner.nextLine();

        if (system.validateAccessCode(code)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied (already used or invalid).");
        }
    }

    private static void showFinance(EventMasterSystem system) {
        System.out.println("\n--- Finance Overview ---");
        System.out.println(system.getFinance());
    }

    private static void showEventsCalendar(EventMasterSystem system) {
        System.out.println("\n--- Events Calendar ---");
        for (Events event : system.getEvents()) {
            System.out.println(event);
        }
    }
}
