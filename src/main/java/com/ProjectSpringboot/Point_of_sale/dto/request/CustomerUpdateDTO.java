package com.ProjectSpringboot.Point_of_sale.dto.request;

import java.util.ArrayList;

public class CustomerUpdateDTO {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private ArrayList<String> customerContact;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(String customerId, String customerName, String customerAddress, ArrayList<String> customerContact) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public ArrayList<String> getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(ArrayList<String> customerContact) {
        this.customerContact = customerContact;
    }

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerContact=" + customerContact +
                '}';
    }
}



