package com.financial.banking.facade;

import com.financial.framework.Account;

public interface BankingService {
    Account createPersonalAccount(String accountNo);
    Account createSavingsAccount(String accountNo);
    Account createCheckingAccount(String accountNo);
    void deposit(String accountNo, double amount);
    void withdraw(String accountNo, double amount);
    void addInterest();
    void generateAccountsReport();
}
