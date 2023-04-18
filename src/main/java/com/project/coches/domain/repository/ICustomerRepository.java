package com.project.coches.domain.repository;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * interface del repositorio de cliente
 */
public interface ICustomerRepository {
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
    Optional<CustomerDto> getCustomerByCardId(String carId);

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
    CustomerDto save(CustomerDto newCustomer);

    /**
     * elimina un cliente dado un carid
     *
     * @param carId identificador del cliente a eliminar
     */
    void delete(String carId);
}
