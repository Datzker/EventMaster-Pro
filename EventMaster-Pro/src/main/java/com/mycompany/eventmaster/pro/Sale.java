/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmaster.pro;

/**
 * Desarrolladores:
 *         - Isabella Gómez Parra.
 *         - Daniel Eduardo González Palacio.
 */

public class Sale {
    private Ticket ticket;
    private String buyerName;
    private String purchaseDate;

    public Sale(Ticket ticket, String buyerName, String purchaseDate) {
        this.ticket = ticket;
        this.buyerName = buyerName;
        this.purchaseDate = purchaseDate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getBuyerName() {
        return buyerName;
    }

    @Override
    public String toString() {
        return "Buyer: " + buyerName + " | Ticket: " + ticket.getType() + " | Purchase Date: " + purchaseDate;
    }
}
