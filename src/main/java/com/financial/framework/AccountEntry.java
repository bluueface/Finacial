package com.financial.framework;

import java.util.Date;

public class AccountEntry {
    private Date date;
    private double amount;
    private String description;
    private String fromAccountNumber;
    private String fromPersonName;
    

    public AccountEntry(double amount, String description, String fromAccountNumber, String fromPersonName) {
        super();
        this.date = new Date();
        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
        this.fromPersonName = fromPersonName;
    }

}
