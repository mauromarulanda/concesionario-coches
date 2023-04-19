package com.project.coches.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * entity de compra
 */
@Getter
@Setter
@Entity
@Table(name = "compras")
public class PurchaseEntity {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_factura")
    private Integer billNumber;
    /**
     *
     */

    @Column(name = "cliente_cedula")
    private Integer cardIdCustomer;
    /**
     *
     */
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;
    /**
     *
     */
    private Double total;
    /**
     *
     */
    @Column(name = "medio_pago")
    private String paymentMethod;
    /**
     *
     */
    @OneToMany(mappedBy = "purchaseEntity", cascade = {CascadeType.ALL})
    private List<CarPurchaseEntity> carsPurchase;

    @ManyToOne
    @JoinColumn(name = "cliente_cedula", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

}
