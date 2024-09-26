package com.financial.framework.strategy;

import com.financial.creditcard.facade.BillingReport;
import com.financial.framework.Account;
import com.financial.framework.iterator.AccountSummaryConsumer;

public interface CreditCardStrategy extends AccountStrategy {
    default BillingReport computeCharge(Account account, int year, int month) {
        AccountSummaryConsumer summary = new AccountSummaryConsumer(year, month, getInterestRate(), getMonthlyPayment());
        account.getEntryList().forEach(summary);

        return summary;
    }

    double getMonthlyPayment();
}
