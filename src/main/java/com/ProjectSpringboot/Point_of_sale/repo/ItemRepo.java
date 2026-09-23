package com.ProjectSpringboot.Point_of_sale.repo;

import com.ProjectSpringboot.Point_of_sale.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, String> {
    List<Item> findByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);

    Item findByItemId(String itemId);
}
