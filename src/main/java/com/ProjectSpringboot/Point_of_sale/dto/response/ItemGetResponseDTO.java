package com.ProjectSpringboot.Point_of_sale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemGetResponseDTO {
    private String itemId;
    private String itemName;
    private double balanceQuantity;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;

}
