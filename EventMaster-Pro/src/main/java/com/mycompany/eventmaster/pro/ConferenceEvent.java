package com.mycompany.eventmaster.pro;

/**
 * Desarrolladores:
 *         - Isabella Gómez Parra.
 *         - Daniel Eduardo González Palacio.
 */

public class ConferenceEvent extends EventBase implements TicketCreatable, FinancialInfoProvider {
    public ConferenceEvent(String name, String date, String time, Location location, double budget) {
        super(name, date, time, location, budget);
    }

    @Override
    public String getCategory() {
        return "Conference";
    }

    @Override
    public String getFinancialInfo() {
        // Implement logic to return financial info for this event
        return "Financial info for conference: Budget $" + budget;
    }

    @Override
    public Ticket createTicket(String type, double price) {
        return new Ticket(type, price);
    }
}
