package com.financial.framework.iterator;

import com.financial.creditcard.facade.BillingReport;
import com.financial.framework.AccountEntry;

import java.time.LocalDate;
import java.util.function.Consumer;

public class AccountSummaryConsumer implements Consumer<AccountEntry>, BillingReport {
    private double totalCharges = 0;
    private double totalCredits = 0;
    private double prevBalance = 0;
    private final double interestRate;
    private final double monthlyPayment;
    private final LocalDate startDate;
    private final LocalDate endDate;


    public AccountSummaryConsumer(int year, int month, double interestRate, double monthlyPayment) {
        startDate = LocalDate.of(year, month, 1);
        endDate = startDate.plusMonths(1);
        this.interestRate = interestRate;
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public void accept(AccountEntry accountEntry) {
        LocalDate entryDate = accountEntry.getDate();
        if (startDate.isAfter(entryDate)) {
            prevBalance += accountEntry.getAmount();
        } else if (!withinAccountingPeriod(entryDate)) {
            return;
        }

        if (accountEntry.getAmount() > 0) totalCredits += accountEntry.getAmount();
        else totalCharges += accountEntry.getAmount();
    }
// 500 2300
    @Override
    public double getBalance() {
        return prevBalance - totalCredits + totalCharges + (interestRate * (prevBalance - totalCredits) / 100);
    }

    @Override
    public double getChargeDue() {
        return monthlyPayment * getBalance() / 100;
    }

    @Override
    public double getTotalCharges() {
        return totalCharges;
    }

    @Override
    public double getTotalCredits() {
        return totalCredits;
    }

    @Override
    public double getPreviousBalance() {
        return prevBalance;
    }

    private boolean withinAccountingPeriod(LocalDate entryDate) {
        return (startDate.isBefore(entryDate) || startDate.equals(entryDate)) && endDate.isAfter(entryDate);
    }
}
