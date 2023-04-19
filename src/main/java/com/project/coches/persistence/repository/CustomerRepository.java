package com.project.coches.persistence.repository;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.persistence.crud.ICustomerCrudRepository;
import com.project.coches.persistence.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {

    private final ICustomerCrudRepository iCustomerCrudRepository;

    private final ICustomerMapper iCustomerMapper;

    /**
     * devuelve una lista de clientes
     *
     * @return lista de clientes
     */
    @Override
    public List<CustomerDto> getAll() {

        return iCustomerMapper.toCustomersDto(iCustomerCrudRepository.findAll());
    }

    /**
     * devuelve un cliente dado un id
     *
     * @param carId identificador del cliente
     * @return cliente dado su id
     */
    @Override
    public Optional<CustomerDto> getCustomerByCardId(String carId) {
        return iCustomerCrudRepository.findById(carId).map(
                iCustomerMapper::toCustomerDto);
    }

    /**
     * devuelve un cliente dado un email
     *
     * @param email email del cliente
     * @return cliente dado su email
     */
    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDto);
    }

    /**
     * guarda un nuevo cliente
     *
     * @param newCustomer cliente a guardar
     * @return cliente guardado
     */
    @Override
    public CustomerDto save(CustomerDto newCustomer) {
        return iCustomerMapper.toCustomerDto
                (iCustomerCrudRepository.save(iCustomerMapper.
                        toCustomerEntity(newCustomer)));
    }

    /**
     * elimina un cliente dado su id
     *
     * @param carId identificador del cliente a eliminar
     */
    @Override
    public void delete(String carId) {
        iCustomerCrudRepository.deleteById(carId);
    }
}
