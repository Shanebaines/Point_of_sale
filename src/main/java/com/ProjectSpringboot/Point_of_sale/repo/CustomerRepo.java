package com.ProjectSpringboot.Point_of_sale.repo;

import com.ProjectSpringboot.Point_of_sale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CustomerRepo extends JpaRepository<Customer, String> {


    List<Customer> findByActiveState(int activeState);
}
