package com.financial.banking.facade;

import com.financial.framework.Account;
import com.financial.framework.builder.CompanyBuilder;
import com.financial.framework.builder.PersonBuilder;

public interface BankingService {
    Account createPersonalAccount(String accountNo, PersonBuilder personBuilder);
    Account createSavingsAccount(String accountNo, CompanyBuilder companyBuilder);
    Account createCheckingAccount(String accountNo,CompanyBuilder companyBuilder);
    void deposit(String accountNo, double amount);
    void withdraw(String accountNo, double amount);
    void addInterest();
    void generateAccountsReport();
}
