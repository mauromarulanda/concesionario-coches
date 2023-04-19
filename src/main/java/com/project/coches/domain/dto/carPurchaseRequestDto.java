package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * dto del guardado de los coches de una compra
 */
@Getter
@Setter
public class carPurchaseRequestDto {
    /**
     *
     */
    private Integer purchaseNumberBill;
    /**
     *
     */
    private Integer codeCar;
    /**
     *
     */
    private Integer quantity;
    /**
     *
     */
    private Double total;
}
