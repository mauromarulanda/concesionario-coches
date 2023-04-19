package com.project.coches.domain.useCase;

import com.project.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarUseCase {
    /**
     * devuelve una lista de todos los coches
     *
     * @return lista de coches
     */
    List<CarDto> getAll();

    /**
     * lista de coches dado el id de su marca
     *
     * @param brandCarId id de la marca
     * @return coches dado el id
     */
    List<CarDto> getByIdBrandCar(Integer brandCarId);

    /**
     * lista de coches con un costo menor a el precio dado
     *
     * @param price precio dado
     * @return lista de coches filtrados
     */
    List<CarDto> getCarsByPriceLessThan(Double price);

    /**
     * devuelve un coche dado su id
     *
     * @param codeCar id del coche
     * @return coche dado su id
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
     * actualiza coche
     *
     * @param carUpdated coche a actualizar
     * @return coche actualizado
     */
    Optional<CarDto> update(CarDto carUpdated);

    /**
     * elimina un coche dado un id
     *
     * @param codeCar id del coche a eliminar
     * @return coche eliminado
     */
    boolean delete(Integer codeCar);
}
