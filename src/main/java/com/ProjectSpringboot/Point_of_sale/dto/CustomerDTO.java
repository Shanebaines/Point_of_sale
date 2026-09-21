package com.ProjectSpringboot.Point_of_sale.dto;

import java.util.ArrayList;

public class CustomerDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private ArrayList<String> customerContact;
    private double customerSalary;
    private String customerNic;
    private int activeState = 0;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, String customerAddress, ArrayList<String> customerContact, double customerSalary, String customerNic, int activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
        this.customerSalary = customerSalary;
        this.customerNic = customerNic;
        this.activeState = activeState;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerContact(ArrayList<String> customerContact) {
        this.customerContact = customerContact;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }

    public void setActiveState(int activeState) {
        this.activeState = activeState;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public ArrayList<String> getCustomerContact() {
        return customerContact;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public String getCustomerNic() {
        return customerNic;
    }

    public int getActiveState() {
        return activeState;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerContact=" + customerContact +
                ", customerSalary=" + customerSalary +
                ", customerNic='" + customerNic + '\'' +
                ", activeState=" + activeState +
                '}';
    }
}
