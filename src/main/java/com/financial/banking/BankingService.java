package com.financial.banking;

import com.financial.framework.Account;
import com.financial.framework.AccountType;
import com.financial.framework.Builder;

public interface BankingService {
    Account createAccount(AccountType type, String accountNumber, Builder builder);
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    void addInterest(String accountNumber, double interestRat);
    void generateAccountsReport();
}
