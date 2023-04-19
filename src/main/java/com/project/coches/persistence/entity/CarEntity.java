package com.project.coches.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * entidad del coche
 */
@Getter
@Setter
@Entity
@Table(name = "coches")
public class CarEntity {
    /**
     * codigo del coche
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_coche", nullable = false)
    private Integer codeCar;
    /**
     * id del coche
     */
    @Column(name = "marca_coche_id")
    private Integer brandCarId;
    /**
     * referencia del coche
     */
    @Column(name = "referencia")
    private String reference;
    /**
     * precio del coche
     */
    @Column(name = "precio")
    private Double price;
    /**
     * modelo del coche
     */
    @Column(name = "anio_modelo")
    private Integer modelYear;
    /**
     * color del coche
     */
    private String color;
    /**
     * caballosd de potencia HP del coche
     */
    @Column(name = "numero_caballos_fuerza")
    private Integer horsePower;
    /**
     * numero de puertas del coche
     */
    @Column(name = "cantidad_puertas")
    private Integer doorNumber;
    /**
     * cilindraje del coche
     */
    @Column(name = "cilindraje")
    private Double engineDisplacement;
    /**
     *
     */
    @Column(name = "transmision")
    private String transmission;
    /**
     * tipo de combustible
     */
    @Column(name = "tipo_combustible")
    private String fuelType;
    /**
     * numero de asientos seatNumber
     */
    @Column(name = "cantidad_asientros")
    private Integer seatNumber;
    /**
     * traccion del coche
     */
    @Column(name = "traccion")
    private Integer traction;
    /**
     * direccion
     */
    @Column(name = "direccion")
    private String steering;
    /**
     * categoria del coche
     */
    @Column(name = "categoria")
    private String category;
    /**
     * imagen del coche
     */
    @Column(name = "ruta_imagen")
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "marca_coche_id", insertable = false, updatable = false)
    private BrandCarEntity brandCarEntity;

}
