package com.mycompany.eventmaster.pro;

/**
 * Desarrolladores:
 *         - Isabella Gómez Parra.
 *         - Daniel Eduardo González Palacio.
 */

public class ConcertEvent extends EventBase implements TicketCreatable, FinancialInfoProvider {
    public ConcertEvent(String name, String date, String time, Location location, double budget) {
        super(name, date, time, location, budget);
    }

    @Override
    public String getCategory() {
        return "Concert";
    }

    @Override
    public String getFinancialInfo() {
        // Implement logic to return financial info for this event
        return "Financial info for concert: Budget $" + budget;
    }

    @Override
    public Ticket createTicket(String type, double price) {
        return new Ticket(type, price);
    }
}
