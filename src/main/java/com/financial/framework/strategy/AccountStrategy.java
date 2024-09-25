package com.financial.framework.strategy;

import com.financial.framework.Account;

public interface AccountStrategy {
    String getName();
    double getInterestRate();

    default double computeInterest(Account account) {
        return account.getBalance() * (1 + getInterestRate() / 100);
    }
}
