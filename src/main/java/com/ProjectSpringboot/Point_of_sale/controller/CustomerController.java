package com.ProjectSpringboot.Point_of_sale.controller;

import com.ProjectSpringboot.Point_of_sale.dto.CustomerDTO;
import com.ProjectSpringboot.Point_of_sale.dto.CustomerUpdateDTO;
import com.ProjectSpringboot.Point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


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
    public CustomerDTO getCustomerById(@RequestParam(value ="Id") String customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        System.out.println("Fetching customer with ID: " + customerId);
        return customerDTO;
    }
    @GetMapping(
            path= "/get-all-customers"
    )
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        System.out.println("Fetching all customers");
        return customers;
    }

    @DeleteMapping(
            path = "/delete-by-id/{Id}"
    )
    public String deleteCustomerById(@PathVariable("Id") String customerId) {
        customerService.deleteCustomerById(customerId);
        return "Deleted Customer with ID: " + customerId + " Successfully";
    }

    @GetMapping(
            path= "/get-all-customers-by-active-state/{activeState}"
    )
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "activeState") boolean activeState) {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersbyactivestate(activeState);
        System.out.println("Fetching all customers with active state: " + activeState);
        return allCustomers;
    }
}
