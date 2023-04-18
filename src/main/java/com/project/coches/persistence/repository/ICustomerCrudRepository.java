package com.project.coches.persistence.repository;

import com.project.coches.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerCrudRepository extends JpaRepository<CustomerEntity, String> {
    /**
     * query method para buscar un cliente por email
     *
     * @param email email del cliente a buscas
     * @return cliente dado el email
     */
    Optional<CustomerEntity> findByEmail(String email);
}
