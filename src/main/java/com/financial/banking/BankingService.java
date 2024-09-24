package com.financial.banking;

import com.financial.framework.Account;

public interface BankingService {
    Account createAccount();
    void deposit(double amount);
    void withdraw(double amount);
    void addInterest();
    void generateAccountsReport();
}
