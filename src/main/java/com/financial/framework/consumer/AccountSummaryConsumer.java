package com.financial.framework.consumer;

import com.financial.framework.AccountEntry;

import java.time.LocalDate;
import java.util.function.Consumer;

public class AccountSummaryConsumer implements Consumer<AccountEntry> {
    private double totalCharges = 0;
    private double totalCredits = 0;
    private double prevBalance = 0;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public AccountSummaryConsumer(int year, int month) {
        startDate = LocalDate.of(year, month, 1);
        endDate = startDate.plusMonths(1);
    }

    @Override
    public void accept(AccountEntry accountEntry) {
        LocalDate entryDate = LocalDate.parse(accountEntry.getDate().toString());
        if (startDate.isAfter(entryDate)) {
            prevBalance += accountEntry.getAmount();
        } else if (!withinAccountingPeriod(entryDate)) {
            return;
        }

        if (accountEntry.getAmount() > 0) totalCredits += accountEntry.getAmount();
        else totalCharges += accountEntry.getAmount();
    }

    public double getTotalCharges() {
        return totalCharges;
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public double getPreviousBalance() {
        return prevBalance;
    }

    private boolean withinAccountingPeriod(LocalDate entryDate) {
        return (startDate.isBefore(entryDate) || startDate.equals(entryDate)) && endDate.isAfter(entryDate);
    }
}
