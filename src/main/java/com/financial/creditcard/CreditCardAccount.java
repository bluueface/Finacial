package com.financial.creditcard;

import com.financial.framework.Account;
import com.financial.framework.strategy.CreditCardStrategy;
import com.financial.framework.Customer;

import java.time.Instant;
import java.util.Date;

public class CreditCardAccount extends Account {
    private final String cardNumber;
    private final Date expiryDate;
    private CreditCardStrategy creditCardStrategy;

    public CreditCardAccount(Customer customer, CreditCardStrategy creditCardStrategy) {
        super(customer, creditCardStrategy);
        cardNumber = this.generateCardNumber();
        expiryDate = this.computeCardExpiry();
    }

    @Override
    public boolean match(String accountNoOrCardNo) {
        return getAccountNumber().equals(accountNoOrCardNo) || cardNumber.equals(accountNoOrCardNo);
    }

    void computeMonthlyBilling(double amount, int year, int month) {
        double charge = creditCardStrategy.computeCharge(this, year, month);
        this.withdraw(charge);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate.toString();
    }

    private String generateCardNumber() {
        return String.valueOf(new Date().getTime()).substring(0, 12);
    }

    private Date computeCardExpiry() {
        return Date.from(Instant.now());
    }
}
