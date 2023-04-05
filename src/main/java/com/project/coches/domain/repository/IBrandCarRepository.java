package com.project.coches.domain.repository;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {
    /**
     * devuelve todas las marcas de coche en una lista
     *
     * @return lista de marcas de coche
     */
    List<BrandCarPojo> getAll();

    /**
     * devuelve una marca de coche dado su id
     *
     * @param id id de marca de coche
     * @return optional de una marca de coche encontrada
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * guarda una nueva marca de coche
     *
     * @param newBrandCar marca de coche a guardar
     * @return marca de coche guardada
     */
    BrandCarPojo save(BrandCarPojo newBrandCar);

    /**
     * elimina una marca de coche dada su id
     * @param idBrandCar id de la marca a eliminar
     */
    void delete(Integer idBrandCar);
}
