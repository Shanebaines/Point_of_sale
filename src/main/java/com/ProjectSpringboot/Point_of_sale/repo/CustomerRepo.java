package com.ProjectSpringboot.Point_of_sale.repo;

import com.ProjectSpringboot.Point_of_sale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
