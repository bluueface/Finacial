package com.financial.framework;

import com.financial.banking.Account;
import com.financial.banking.Customer;

public interface AccountFactory {
    Account createAccount(String accountNumber, Customer customer);
}
