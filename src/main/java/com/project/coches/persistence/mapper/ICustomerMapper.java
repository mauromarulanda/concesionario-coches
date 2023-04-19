package com.project.coches.persistence.mapper;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * mapper de customer
 */
@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    /**
     * convierte una entidad de customer a dto
     * @param customerEntity entidad a convertir
     * @return dto convertido
     */
    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    /**
     * convierte un dto a entidad de customer
     * @param customerDto dto a convertir
     * @return entidad convertida
     */
    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    /**
     * convierte una lista de tipo entidad a dto y la retorna de customers
     * @param customerEntityList lista a convertir
     * @return lista convertida
     */
    List<CustomerDto> toCustomersDto(List<CustomerEntity> customerEntityList);
}
