package com.project.coches.domain.service;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * interface de servicio del cliente
 */
public interface ICustomerService {
    /**
     * devuelve una lista con todos los clientes
     *
     * @return lista de todos los cliente
     */
    List<CustomerDto> getAll();

    /**
     * devuelve un cliente dado un cadId
     *
     * @param carId identificador del cliente
     * @return cliente dado el id
     */
    Optional<CustomerDto> getCustomerByCarId(String carId);

    /**
     * devuelve un cliente dado un email
     *
     * @param email email del cliente
     * @return cliente dado el email
     */
    Optional<CustomerDto> getCustomerByEmail(String email);

    /**
     * guarda un nuevo cliente
     *
     * @param newCustomer cliente a guardar
     * @return cliente guardado
     */
    ResponseCustomerDto save(CustomerDto newCustomer);

    /**
     * actualiza informacion de un cliente
     *
     * @param modifyCustomer cuerpo del cliente a modificar
     * @return cliente modificado
     */
    Optional<CustomerDto> update(CustomerDto modifyCustomer);

    /**
     * elimina un cliente dado un carid
     *
     * @param carId identificador del cliente a eliminar
     */
    boolean delete(String carId);
}
