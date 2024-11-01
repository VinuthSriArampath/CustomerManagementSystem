package edu.icet.service.impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    final CustomerRepository customerRepository;
    final ModelMapper mapper;
    @Override
    public List<Customer> getCustomer() {
        List<Customer> customerList= new ArrayList<> ();
        customerRepository.findAll().forEach(customerEntity -> {
            customerList.add(mapper.map(customerEntity, Customer.class));

        });
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(mapper.map(customer, CustomerEntity.class));
    }

    @Override
    public Customer searchCustomerById(Integer id) {
        return mapper.map(customerRepository.findById(id), Customer.class);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
