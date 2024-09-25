package com.financial.framework;

import com.financial.framework.facade.AccountDAO;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDAOImpl implements AccountDAO {
    Collection<Account> accountList = new ArrayList<Account>();

    public void saveAccount(Account account) {
        accountList.add(account); // add the new
    }

    public void updateAccount(Account account) {
        Account accountExists = loadAccount(account.getAccountNumber());
        if (accountExists != null) {
            accountList.remove(accountExists); // remove the old
            accountList.add(account); // add the new
        }
    }

    public Account loadAccount(String accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public Collection<Account> getAccounts() {
        return accountList;
    }

}
