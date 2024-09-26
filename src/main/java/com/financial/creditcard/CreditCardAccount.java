package com.financial.creditcard;

import com.financial.creditcard.facade.BillingReport;
import com.financial.framework.Account;
import com.financial.framework.strategy.CreditCardStrategy;
import com.financial.framework.Customer;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class CreditCardAccount extends Account {
    private final String cardNumber;
    private final LocalDate expiryDate;

    public CreditCardAccount(Customer customer, CreditCardStrategy creditCardStrategy) {
        super(customer, creditCardStrategy);
        cardNumber = this.generateCardNumber();
        expiryDate = this.computeCardExpiry();
    }

    @Override
    public boolean match(String accountNoOrCardNo) {
        return getAccountNumber().equals(accountNoOrCardNo) || cardNumber.equals(accountNoOrCardNo);
    }

    public BillingReport generateMonthlyReport() {
        LocalDate now = LocalDate.now();
        CreditCardStrategy strategy = (CreditCardStrategy) getAccountStrategy();
        return strategy.computeCharge(this, now.getYear(), now.getMonthValue());
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate.format(DateTimeFormatter.ofPattern("MM/yyyy"));
    }

    private String generateCardNumber() {
        return String.valueOf(new Date().getTime()).substring(0, 12);
    }

    private LocalDate computeCardExpiry() {
        return LocalDate.now().plusYears(4);
    }

    public String getAccountType() {
        return getAccountStrategy().getName();
    }
}
