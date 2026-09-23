package com.ProjectSpringboot.Point_of_sale.util.mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.ProjectSpringboot.Point_of_sale.dto.response.ItemGetResponseDTO;
import com.ProjectSpringboot.Point_of_sale.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel ="spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDTOList(List<Item> items);
}
