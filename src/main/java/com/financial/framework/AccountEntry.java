package com.financial.framework;

import java.time.LocalDate;
import java.util.Date;

public class AccountEntry {
    private final LocalDate date;
    private final double amount;
    private final String description;
    private final double balance;

    public AccountEntry(double amount, String description) {
        super();
        this.date = LocalDate.now();
        this.amount = amount;
        this.description = description;
        balance = 0;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
