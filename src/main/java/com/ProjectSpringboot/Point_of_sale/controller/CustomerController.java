package com.ProjectSpringboot.Point_of_sale.controller;

import com.ProjectSpringboot.Point_of_sale.dto.request.CustomerDTO;
import com.ProjectSpringboot.Point_of_sale.dto.request.CustomerUpdateDTO;
import com.ProjectSpringboot.Point_of_sale.service.CustomerService;
import com.ProjectSpringboot.Point_of_sale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save01")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        String name = customerService.saveCustomer(customerDTO);
        return ResponseEntity.ok(new StandardResponse(200, "Saved Customer Successfully", name));
    }

    @PutMapping("/update01")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String result = customerService.updateCustomer(customerUpdateDTO);
        return ResponseEntity.ok(new StandardResponse(200, result, null));
    }

    @GetMapping(path = "/get-by-id", params = "Id")
    public ResponseEntity<StandardResponse> getCustomerById(@RequestParam(value = "Id") String customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(new StandardResponse(200, "Customer fetched successfully", customerDTO));
    }

    @GetMapping(path = "/get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(new StandardResponse(200, "Customers fetched successfully", customers));
    }

    @DeleteMapping(path = "/delete-by-id/{Id}")
    public ResponseEntity<StandardResponse> deleteCustomerById(@PathVariable("Id") String customerId) {
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.ok(new StandardResponse(200, "Deleted Customer Successfully", null));
    }

    @GetMapping(path = "/get-all-customers-by-active-state/{activeState}")
    public ResponseEntity<StandardResponse> getAllCustomersByActiveState(@PathVariable(value = "activeState") boolean activeState) {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersbyactivestate(activeState);
        return ResponseEntity.ok(new StandardResponse(200, "Customers fetched successfully", allCustomers));
    }
}
