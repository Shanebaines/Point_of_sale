package com.ProjectSpringboot.Point_of_sale.service;

import com.ProjectSpringboot.Point_of_sale.dto.CustomerDTO;
import com.ProjectSpringboot.Point_of_sale.dto.CustomerUpdateDTO;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    public CustomerDTO getCustomerById(int customerId);
}
