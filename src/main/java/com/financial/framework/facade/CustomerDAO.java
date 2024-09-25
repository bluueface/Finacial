package com.financial.framework.facade;

import com.financial.framework.Account;
import com.financial.framework.Customer;

import java.util.Collection;

public interface CustomerDAO {
    void saveCustomer(Account account);
    void updateCustomer(Customer customer);
    Collection<Customer> getCustomers();
}
