package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO del guardado de una compra
 */
@Getter
@Setter
public class PurchaseRequestDto {
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
    /**
     *
     */
    private List<carPurchaseRequestDto> carsPurchase;


}
