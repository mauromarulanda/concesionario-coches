package com.project.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * dto de un cliente
 */
@Getter @Setter
public class CustomerDto {
    /**
     * id del cliente
     */
    private String cardId;
    /**
     * nombre completo del cliente
     */
    private String fullName;
    /**
     * email del cliente
     */
    private String email;
    /**
     * contraseña del cliente
     */
    private String password;
    /**
     * telefono del cliente
     */
    private Double numberCellphone;
    /**
     * estado del cliente
     */
    private Integer active;

    /**
     * tostring de customerDTO
     * @return customerDTO
     */
    @Override
    public String toString() {
        return "CustomerDto{" +
                "cardId='" + cardId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", numberCellphone=" + numberCellphone +
                ", active=" + active +
                '}';
    }
}
