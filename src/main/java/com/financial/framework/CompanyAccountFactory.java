package com.financial.framework;

import com.financial.banking.Account;
import com.financial.banking.Customer;
import com.financial.banking.SavingsAccount;

public class CompanyAccountFactory implements AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer) {
        return new SavingsAccount(accountNumber, customer);
    }
}
