package com.financial.banking;

import com.financial.framework.Account;
import com.financial.framework.AccountType;

import java.util.Collection;

public interface BankingService  {
    Account createAccount(String accountNumber, String customerName);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest(String accountNumber, InterestStrategy strategy);
    void generateAccountsReport(String startOfMonth, String endOfMonth);
}