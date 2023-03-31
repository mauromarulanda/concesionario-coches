package com.project.coches.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * entidad de la marca coche
 */
@Getter @Setter
@Entity
@Table(name = "marca_coche")
public class MarchaCocheEntity {

    /**
     * id de la marca
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * descripcion de la marca
     */
    @Column(name = "descripcion")
    private String description;

}
