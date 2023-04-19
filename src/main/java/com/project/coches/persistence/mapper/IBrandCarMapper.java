package com.project.coches.persistence.mapper;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.persistence.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * mapper que transforma objetos de MarcaCoche a pojos o entidades
 */
@Mapper(componentModel = "spring")
public interface IBrandCarMapper {
    /**
     * convierte una entidad a un pojo de marcacoche
     *
     * @param marcaEntity entidad a convertir
     * @return pojo convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarDto toMarcaCocheDto(BrandCarEntity marcaEntity);

    /**
     * convierte un pojo a una entidad de marcacoche
     *
     * @param marcaDto pojo convertido
     * @return entidad convertida
     */
    @InheritInverseConfiguration
    @Mapping(target = "carEntities", ignore = true)
    BrandCarEntity toMarcaCocheEntity(BrandCarDto marcaDto);

    /**
     * retorna una lista de marcascoche transformada a pojo de una lista de entidades
     * @param marcasCocheEntity entidad a transformar
     * @return lista transformada
     */
    List<BrandCarDto> toMarcasCocheDto(List<BrandCarEntity> marcasCocheEntity);
}
