package com.ProjectSpringboot.Point_of_sale.util.mappers;

import com.ProjectSpringboot.Point_of_sale.dto.response.ItemGetResponseDTO;
import com.ProjectSpringboot.Point_of_sale.entity.Item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    @Autowired
    private ModelMapper modelMapper;

    public List<ItemGetResponseDTO> entityListToDTOList(List<Item> items) {
        return items.stream()
                .map(item -> modelMapper.map(item, ItemGetResponseDTO.class))
                .collect(Collectors.toList());
    }
}

