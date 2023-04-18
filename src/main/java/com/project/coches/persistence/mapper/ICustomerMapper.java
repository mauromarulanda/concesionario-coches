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

    CustomerDto toCustomerDto(CustomerEntity customerEntity);

    CustomerEntity toCustomerEntity(CustomerDto customerDto);

    List<CustomerDto> toCustomersDto(List<CustomerEntity> customerEntityList);
}
