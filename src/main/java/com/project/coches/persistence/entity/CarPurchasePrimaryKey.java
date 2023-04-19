package com.project.coches.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class CarPurchasePrimaryKey implements Serializable {

    @Serial
    private static final long serialVersionUID = 22L;
    /**
     *
     */
    @Column(name = "compras_numero_factura")
    private Integer purchaseNumberBill;
    /**
     *
     */
    @Column(name = "coches_codigo_coche")
    private Integer codeCar;

}
