package com.ProjectSpringboot.Point_of_sale.entity;


import com.ProjectSpringboot.Point_of_sale.entity.enums.MeasuringUnit;
import com.ProjectSpringboot.Point_of_sale.util.ItemIdGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data

public class Item {
    @Id
    @GeneratedValue(generator = "item-id-gen")
    @GenericGenerator(name = "item-id-gen", type = ItemIdGenerator.class)
    @Column(name = "item_id", length = 45)
    private String itemId;

    @Column(name = "item_name", nullable = false, length = 100)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measurementUnit", nullable = false, length = 100)
    private MeasuringUnit measurementUnit;

    @Column(name = "balanceQuantity", nullable = false,length = 100)
    private double balanceQuantity;

    @Column(name = "supplierPrice",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name = "sellingPrice",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name = "activeState")
    private boolean activeState;



}
