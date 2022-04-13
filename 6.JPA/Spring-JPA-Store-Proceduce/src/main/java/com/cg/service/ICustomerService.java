package com.cg.service;

import com.cg.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
