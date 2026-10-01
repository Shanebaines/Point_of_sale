package com.ProjectSpringboot.Point_of_sale.dto.paginated;

import com.ProjectSpringboot.Point_of_sale.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDto {
    List<ItemGetResponseDTO> list;
    private long dataCount;
}
