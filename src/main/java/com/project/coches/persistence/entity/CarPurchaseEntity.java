package com.project.coches.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * entity de coche_compra
 */
@Getter
@Setter
@Entity
@Table(name = "coches_compras")
public class CarPurchaseEntity {

    @EmbeddedId
    private CarPurchasePrimaryKey id;
    /**
     *
     */
    @Column(name = "cantidad")
    private Integer quantity;
    /**
     *
     */
    private Double total;

    @ManyToOne
    @MapsId(value = "purchaseNumberBill")
    @JoinColumn(name = "compras_numero_factura", insertable = false, updatable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne
    @JoinColumn(name = "coches_codigo_coche", insertable = false, updatable = false)
    private CarEntity carEntity;
}
