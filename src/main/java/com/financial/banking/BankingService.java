package com.financial.banking;

import com.financial.framework.Account;
import com.financial.framework.AccountType;

public interface BankingService {
    Account createAccount(AccountType type, String accountNumber);
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    void addInterest(String accountNumber, double interestRat);
    void generateAccountsReport();
}
