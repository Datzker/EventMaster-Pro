/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmaster.pro;

import java.util.HashSet;

/**
 * Desarrolladores:
 *         - Isabella Gómez Parra.
 *         - Daniel Eduardo González Palacio.
 */

public class AccessControl {
    private HashSet<String> validatedCodes;

    public AccessControl() {
        validatedCodes = new HashSet<>();
    }

    public boolean validateTicket(String code) {
        return validatedCodes.add(code);
    }

    public int getTotalAttendees() {
        return validatedCodes.size();
    }
}
