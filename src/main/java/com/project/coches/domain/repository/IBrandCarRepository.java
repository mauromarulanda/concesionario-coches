package com.project.coches.domain.repository;

import com.project.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

/**
 * interface del repositorio de marca coche
 */
public interface IBrandCarRepository {
    /**
     * devuelve todas las marcas de coche en una lista
     *
     * @return lista de marcas de coche
     */
    List<BrandCarDto> getAll();

    /**
     * devuelve una marca de coche dado su id
     *
     * @param id id de marca de coche
     * @return optional de una marca de coche encontrada
     */
    Optional<BrandCarDto> getBrandCar(Integer id);

    /**
     * guarda una nueva marca de coche
     *
     * @param newBrandCar marca de coche a guardar
     * @return marca de coche guardada
     */
    BrandCarDto save(BrandCarDto newBrandCar);

    /**
     * elimina una marca de coche dada su id
     * @param idBrandCar id de la marca a eliminar
     */
    void delete(Integer idBrandCar);
}
