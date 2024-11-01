package edu.icet.service;

import edu.icet.dto.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomer();
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer searchCustomerById(Integer id);
    void deleteCustomer(Integer id);
}
