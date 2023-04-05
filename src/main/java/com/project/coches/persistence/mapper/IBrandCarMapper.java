package com.project.coches.persistence.mapper;

import com.project.coches.domain.pojo.BrandCarPojo;
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
     * @param marchaEntity entidad a convertir
     * @return pojo convertido
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    BrandCarPojo toMarcaCochePojo(BrandCarEntity marchaEntity);

    /**
     * convierte un pojo a una entidad de marcacoche
     *
     * @param marcaPojo pojo convertido
     * @return entidad convertida
     */
    @InheritInverseConfiguration
    BrandCarEntity toMarcaCocheEntity(BrandCarPojo marcaPojo);

    /**
     * retorna una lista de marcascoche transformada a pojo de una lista de entidades
     * @param marcasCocheEntity entidad a transformar
     * @return lista transformada
     */
    List<BrandCarPojo> toMarcasCochePojo(List<BrandCarEntity> marcasCocheEntity);
}
