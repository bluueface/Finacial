package com.financial.banking;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    protected long id;
    protected String name;
    protected List<Account> accounts;

    public Customer() {
        accounts = new ArrayList<Account>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

}
