package com.ProjectSpringboot.Point_of_sale.service;

import com.ProjectSpringboot.Point_of_sale.dto.request.ItemDTO;
import com.ProjectSpringboot.Point_of_sale.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {

    String saveItem (ItemDTO itemDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    String updateActiveState(String itemId, boolean activeState);
}
