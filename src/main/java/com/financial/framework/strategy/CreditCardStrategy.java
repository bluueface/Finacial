package com.financial.framework.strategy;

import com.financial.framework.Account;
import com.financial.framework.consumer.AccountSummaryConsumer;

public interface CreditCardStrategy extends AccountStrategy {
    default double computeCharge(Account account, int year, int month) {
        AccountSummaryConsumer summary = new AccountSummaryConsumer(year, month);
        account.getEntryList().forEach(summary);

        double prevBal = summary.getPreviousBalance();
        double totalCharges = summary.getTotalCharges();
        double totalCredits = summary.getTotalCredits();
        double newBalance = prevBal - totalCredits + totalCharges + getInterestRate() * (prevBal - totalCredits);
        return getMonthlyPayment() * newBalance;
    }

    double getMonthlyPayment();
}
