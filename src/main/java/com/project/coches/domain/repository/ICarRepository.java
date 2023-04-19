package com.project.coches.domain.repository;

import com.project.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

/**
 * interface del repositorio de coche
 */
public interface ICarRepository {
    /**
     * retorna una lista de todos los coches
     *
     * @return lista de coches
     */
    List<CarDto> getAll();

    /**
     * devuelve una lista de los coches de una marca dado un id de la marca
     *
     * @param brandCarId id de la marca
     * @return lista de coches de la marca de coches
     */
    List<CarDto> getByIdBrandCar(Integer brandCarId);

    /**
     * devuelve una lista de coches con un precio menor a un precio dado
     *
     * @param price precio dado
     * @return lista de coches filtrados
     */
    List<CarDto> getCarsByPriceLessThan(Double price);

    /**
     * retorna un coche dado un identificador del coche
     *
     * @param codeCar id del coche
     * @return coche dado un id
     */
    Optional<CarDto> getCar(Integer codeCar);


    /**
     * guarda un nuevo coche
     *
     * @param newCar coche a guardar
     * @return coche guardado
     */
    CarDto save(CarDto newCar);

    /**
     * elimina un coche dado un identificador del coche
     *
     * @param codeCar id del coche a eliminar
     */
    void delete(Integer codeCar);
}
