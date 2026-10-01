package com.ProjectSpringboot.Point_of_sale.repo;

import com.ProjectSpringboot.Point_of_sale.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, String> {
    List<Item> findByItemNameEqualsAndActiveStateEquals(String itemName, boolean b);

    Item findByItemId(String itemId);

    List<Item> findByActiveStateEquals(boolean activeState);

    Page<Item> findByActiveStateEquals(boolean activeState, Pageable pageable);
}
