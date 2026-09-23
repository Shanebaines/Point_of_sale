package com.ProjectSpringboot.Point_of_sale.dto.request;


import com.ProjectSpringboot.Point_of_sale.entity.enums.MeasuringUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ItemDTO {

    private String itemName;
    private MeasuringUnit measurementUnit;
    private double balanceQuantity;
    private double supplierPrice;
    private double sellingPrice;

}
