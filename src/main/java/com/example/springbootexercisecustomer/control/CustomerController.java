package com.example.springbootexercisecustomer.control;

import com.example.springbootexercisecustomer.model.Customer;
import com.example.springbootexercisecustomer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/coustomers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    @GetMapping
    public ArrayList<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/{id}")
    public Customer getCustomerByID(@PathVariable int id){
        return customerService.getCustomerByID(id);
    }

    @PutMapping("/{id}")
    public void updateCustomerByID(@PathVariable int id,@RequestBody Customer newCustomer){
        customerService.updateCustomerByID(id, newCustomer);
    }

}
