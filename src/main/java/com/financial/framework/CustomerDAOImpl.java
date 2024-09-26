package com.financial.framework;

import com.financial.framework.facade.CustomerDAO;

import java.util.*;

public class CustomerDAOImpl implements CustomerDAO {
    Set<Customer> customerList = new HashSet<>();

    @Override
    public void saveCustomer(Customer customer) {
        Customer customerExists = customerList.stream()
                .filter(c -> c.equals(customer))
                .findFirst()
                .orElse(null);
        if (customerExists != null) {
            customerList.remove(customerExists);
            customerExists.getAccounts().forEach(customer::addAccount);
        }
        customerList.add(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        boolean customerExists = customerList.contains(customer);
        if (customerExists) {
            customerList.remove(customer);
            customerList.add(customer);
        }
    }

    public Customer loadCustomer(String name) {
        return customerList.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Collection<Customer> getCustomers() {
        return customerList;
    }

}
