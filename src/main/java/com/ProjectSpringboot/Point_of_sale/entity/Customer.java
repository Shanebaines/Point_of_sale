package com.ProjectSpringboot.Point_of_sale.entity;

import com.ProjectSpringboot.Point_of_sale.util.CustomerIdGenerator;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.ArrayList;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(generator = "customer-id-gen")
    @GenericGenerator(name = "customer-id-gen", type = CustomerIdGenerator.class)
    @Column(name = "customer_id", length = 20)
    private String customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 225)
    private String customerAddress;

    @Type(JsonType.class)
    @Column(name = "customer_contact", columnDefinition = "json")
    private ArrayList<String> customerContact;

    @Column(name = "customer_salary", length = 45)
    private double customerSalary;

    @Column(name = "customer_nic", length = 45)
    private String customerNic;

    // 0 = Inactive, 1 = Active
    @Column(name = "active_state", columnDefinition = "TINYINT DEFAULT 0")
    private int activeState = 0;


    // Default constructor
    public Customer() {
    }


    // Parameterized constructor (customerId is auto-generated — do NOT pass it)
    public Customer(String customerName,
                    String customerAddress,
                    ArrayList<String> customerContact,
                    double customerSalary,
                    String customerNic,
                    int activeState) {

        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContact = customerContact;
        this.customerSalary = customerSalary;
        this.customerNic = customerNic;
        this.activeState = activeState;
    }


    // Getters and Setters

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


    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }


    public String getCustomerNic() {
        return customerNic;
    }

    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }


    public int getActiveState() {
        return activeState;
    }

    public void setActiveState(int activeState) {
        this.activeState = activeState;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerContact=" + customerContact +
                ", customerSalary=" + customerSalary +
                ", customerNic='" + customerNic + '\'' +
                ", activeState=" + activeState +
                '}';
    }
}