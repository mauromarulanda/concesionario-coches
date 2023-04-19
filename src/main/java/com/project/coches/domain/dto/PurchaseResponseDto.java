package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * dto de la consulta de una compra
 */
@Getter
@Setter
public class PurchaseResponseDto {
    /**
     *
     */
    private Integer billNumber;
    /**
     *
     */
    private Integer cardIdCustomer;
    /**
     *
     */
    private LocalDateTime date;
    /**
     *
     */
    private Double total;
    /**
     *
     */
    private String paymentMethod;

    private List<carPurchaseResponseDto> carsPurchase;
}
