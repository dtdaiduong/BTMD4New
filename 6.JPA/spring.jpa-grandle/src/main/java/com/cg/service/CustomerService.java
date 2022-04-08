package com.cg.service;

import com.cg.model.Customer;
import com.cg.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public  List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id){
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customers){
        customerRepository.save(customers);
    }

    @Override
    public void remove(Long id){
        customerRepository.remove(id);
    }
}
