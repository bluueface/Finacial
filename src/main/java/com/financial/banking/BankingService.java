package com.financial.banking;

import com.financial.framework.Account;
import com.financial.framework.AccountType;
import com.financial.framework.Company;
import com.financial.framework.Party;

import java.util.Collection;

public interface BankingService  {
    Account createAccount(Party customerParty, String accountNo);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest(String accountNumber, InterestStrategy strategy);
    void generateAccountsReport(String startOfMonth, String endOfMonth);
}