package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * dto de un coche
 */
@Getter @Setter
public class CarDto {
    /**
     * codigo del coche
     */
    private Integer codeCar;
    /**
     * id del coche
     */
    private Integer brandCarId;
    /**
     * referencia del coche
     */
    private String reference;
    /**
     * precio del coche
     */
    private Double price;
    /**
     * modelo del coche
     */
    private Integer modelYear;
    /**
     * color del coche
     */
    private String color;
    /**
     * caballosd de potencia HP del coche
     */
    private Integer horsePower;
    /**
     * numero de puertas del coche
     */
    private Integer doorNumber;
    /**
     * cilindraje del coche
     */
    private Double engineDisplacement;
    /**
     *
     */
    private String transmission;
    /**
     * tipo de combustible
     */
    private String fuelType;
    /**
     * numero de asientos seatNumber
     */
    private Integer seatNumber;
    /**
     * traccion del coche
     */
    private Integer traction;
    /**
     * direccion
     */
    private String steering;
    /**
     * categoria del coche
     */
    private String category;
    /**
     * imagen del coche
     */
    private String imagePath;

}
