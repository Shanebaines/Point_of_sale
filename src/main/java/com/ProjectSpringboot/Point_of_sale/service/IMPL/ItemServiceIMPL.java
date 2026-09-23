package com.ProjectSpringboot.Point_of_sale.service.IMPL;

import com.ProjectSpringboot.Point_of_sale.dto.request.ItemDTO;
import com.ProjectSpringboot.Point_of_sale.dto.response.ItemGetResponseDTO;
import com.ProjectSpringboot.Point_of_sale.entity.Item;
import com.ProjectSpringboot.Point_of_sale.repo.ItemRepo;
import com.ProjectSpringboot.Point_of_sale.service.ItemService;
import com.ProjectSpringboot.Point_of_sale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service

public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public String saveItem(ItemDTO itemDTO) {

        Item item = modelMapper.map(itemDTO, Item.class);
        item.setActiveState(true); // Mark item as active on save

        itemRepo.save(item);
        return "Saved Item Successfully";
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        List<Item> items = itemRepo.findByItemNameEqualsAndActiveStateEquals(itemName, true);
        if (!items.isEmpty()) {
            return itemMapper.entityListToDTOList(items);
        }
        return List.of(); // Return empty list instead of throwing 500
    }

    @Override
    @Transactional
    public String updateActiveState(String itemId, boolean activeState) {
        Item item = itemRepo.findByItemId(itemId);
        if (item == null) {
            return "Item not found with ID: " + itemId;
        }
        item.setActiveState(activeState);
        itemRepo.save(item);
        return "Item active state updated successfully";
    }
}