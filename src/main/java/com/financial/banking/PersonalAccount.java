package com.financial.banking;

import com.financial.framework.Account;

public class PersonalAccount extends Account {
    public PersonalAccount(String accountNumber, Person person) {
        super(accountNumber, person);
    }
}
