package com.project.coches.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entidad de un cliente
 */
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class CustomerEntity {
    /**
     * id del ciente
     */
    @Id
    @Column(name = "cedula")
    private String cardId;
    /**
     * nombre completo del cliente
     */
    @Column(name = "nombre_completo")
    private String fullName;
    /**
     * email del cliente
     */
    @Column(name = "correo")
    private String email;
    /**
     * contraseña del cliente
     */
    @Column(name = "contrasenia")
    private String password;
    /**
     * telefono del cliente
     */
    @Column(name = "numero_celular")
    private Double numberCellphone;
    /**
     * estado del cliente
     */
    @Column(name = "activo")
    private Integer active;

    /**
     * rol del cliente
     */
    private String rol;

    @OneToMany(mappedBy = "customerEntity")
    private List<PurchaseEntity> purchaseEntity;

}
