package com.financial.framework.facade;

import com.financial.framework.Account;
import com.financial.framework.Customer;

import java.util.Collection;

public interface CustomerDAO {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Collection<Customer> getCustomers();
}
