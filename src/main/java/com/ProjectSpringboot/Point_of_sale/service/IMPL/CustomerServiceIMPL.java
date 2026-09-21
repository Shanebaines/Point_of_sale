package com.ProjectSpringboot.Point_of_sale.service.IMPL;
import com.ProjectSpringboot.Point_of_sale.dto.CustomerDTO;
import com.ProjectSpringboot.Point_of_sale.dto.CustomerUpdateDTO;
import com.ProjectSpringboot.Point_of_sale.entity.Customer;
import com.ProjectSpringboot.Point_of_sale.repo.CustomerRepo;
import com.ProjectSpringboot.Point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerServiceIMPL implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;

    @Transactional
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
          customerDTO.getCustomerId()
          ,customerDTO.getCustomerName()
          , customerDTO.getCustomerAddress()
          ,customerDTO.getCustomerContact()
          ,customerDTO.getCustomerSalary()
          ,customerDTO.getCustomerNic()
                ,customerDTO.getActiveState()
        );
        customerRepo.save(customer);

        return customerDTO.getCustomerName();
    }

    @Transactional
    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        Customer customer = customerRepo.findById(customerUpdateDTO.getCustomerId()).orElse(null);
        if (customer != null) {
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerContact(customerUpdateDTO.getCustomerContact());
            customerRepo.save(customer);
        }
        return "Updated Customer Successfully";
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if (customer != null) {
            return new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerContact(),
                    customer.getCustomerSalary(),
                    customer.getCustomerNic(),
                    customer.getActiveState()
            );
        }
        return null;
    }

}
