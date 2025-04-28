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

public class Finance {
    private double totalBudget;
    private double income;
    private double expenses;

    public Finance(double totalBudget) {
        this.totalBudget = totalBudget;
        this.income = 0;
        this.expenses = 0;
    }

    public void addIncome(double amount) {
        income += amount;
    }

    public void addExpense(double amount) {
        expenses += amount;
    }

    public double calculateBalance() {
        return totalBudget + income - expenses;
    }

    @Override
    public String toString() {
        return "Total Budget: $" + totalBudget + " | Income: $" + income + " | Expenses: $" + expenses + " | Balance: $" + calculateBalance();
    }
}
