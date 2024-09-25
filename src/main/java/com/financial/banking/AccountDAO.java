package com.financial.banking;

import com.financial.framework.Account;

import java.util.Collection;
public interface AccountDAO {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account loadAccount(String accountnumber);
    Collection<Account> getAccounts();
}
