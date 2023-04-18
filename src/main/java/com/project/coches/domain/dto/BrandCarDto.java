package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * pojo de marca coche
 */
@Getter @Setter
public class BrandCarDto {

    /**
     * Id de la marca coche
     */
    private  Integer id;
    /**
     * descripcion de la marca coche
     */
    private String description;
}
