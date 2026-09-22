package com.ProjectSpringboot.Point_of_sale.service;

import com.ProjectSpringboot.Point_of_sale.dto.CustomerDTO;
import com.ProjectSpringboot.Point_of_sale.dto.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    public CustomerDTO getCustomerById(String customerId);

    List<CustomerDTO> getAllCustomers();

    void deleteCustomerById(String customerId);

    List<CustomerDTO> getAllCustomersbyactivestate(boolean activeState);

}
