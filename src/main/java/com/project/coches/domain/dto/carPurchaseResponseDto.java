package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * dto de la consulta de los coches de una compra
 */
@Getter
@Setter
public class carPurchaseResponseDto {
    /**
     *
     */
    private String referenceCar;
    /**
     *
     */
    private Integer quantity;
    /**
     *
     */
    private Double total;
}
