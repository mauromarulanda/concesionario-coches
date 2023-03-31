package com.project.coches.domain.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * pojo de marca coche
 */
@Getter @Setter
public class MarcaCochePojo {

    /**
     * Id de la marca coche
     */
    private  Integer id;
    /**
     * descripcion de la marca coche
     */
    private String description;
}
