package com.financial.framework;

import com.financial.banking.Account;
import com.financial.banking.Customer;

public class PersonAccountFactory implements AccountFactory {
    private Object object3 = new Object();

	@Override
	public Account createAccount(String accountNumber, Customer customer) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'createAccount'");
	}

    public void createSmithA(String acctNo, String name, String... args) {
        // object2.createPersonalAccount();
    }

    public void createSmithB1(String acctNo, String name, String... args) {
        // object.createSavingsAccount();
    }

    public void createSmithB2(String acctNo, String name, String... args) {
        // object.createCheckingAccount();
    }
}
