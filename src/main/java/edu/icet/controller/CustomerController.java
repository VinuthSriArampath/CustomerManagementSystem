package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/getAll")
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }
    @GetMapping("/search/{id}")
    public Customer searchCustomer(@PathVariable Integer id){
        return customerService.searchCustomerById(id);
    }
    @PatchMapping("/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
    }

}
