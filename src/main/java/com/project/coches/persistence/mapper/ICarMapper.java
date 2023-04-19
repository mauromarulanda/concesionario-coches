package com.project.coches.persistence.mapper;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.persistence.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 *
 */
@Mapper(componentModel = "spring")
public interface ICarMapper {
    /**
     * convierte una entidad a un dto de coche
     * @param carEntity entidad a convertir
     * @return dto convertido
     */
    CarDto toCarDto(CarEntity carEntity);

    /**
     * convierte un dto a una entidad de coche
     * @param carDto dto a convertir
     * @return entidad convertida
     */
    @Mapping(target = "brandCarEntity", ignore = true)
    @Mapping(target = "carPurchaseEntity", ignore = true)
    CarEntity toCarEntity(CarDto carDto);

    /**
     * devuelve una lista de coche entidad transformada a dtos
     * @param carEntityList lista de entidad a transformar
     * @return lista de coches dtos
     */
    List<CarDto> toCarsDto(List<CarEntity> carEntityList);
}
