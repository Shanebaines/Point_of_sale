package com.ProjectSpringboot.Point_of_sale.controller;

import com.ProjectSpringboot.Point_of_sale.dto.CustomerDTO;
import com.ProjectSpringboot.Point_of_sale.dto.CustomerUpdateDTO;
import com.ProjectSpringboot.Point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save01")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return "Saved Customer Successfully";
    }

    @PutMapping("/update01")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        customerService.updateCustomer(customerUpdateDTO);
        return customerUpdateDTO.getCustomerName() + " - Updated Customer Successfully";
    }

    @GetMapping(
            path = "/get-by-id",
            params = "Id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value ="Id") int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        System.out.println("Fetching customer with ID: " + customerId);
        return customerDTO;
    }
}
