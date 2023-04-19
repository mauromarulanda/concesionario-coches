package com.project.coches.domain.service;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.domain.useCase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService implements ICarUseCase {

    private final ICarRepository iCarRepository;

    /**
     * devuelve una lista de todos los coches
     *
     * @return lista de coches
     */
    @Override
    public List<CarDto> getAll() {
        return iCarRepository.getAll();
    }

    /**
     * lista de coches dado el id de su marca
     *
     * @param brandCarId id de la marca
     * @return coches dado el id
     */
    @Override
    public List<CarDto> getByIdBrandCar(Integer brandCarId) {
        return iCarRepository.getByIdBrandCar(brandCarId);
    }

    /**
     * lista de coches con un costo menor a el precio dado
     *
     * @param price precio dado
     * @return lista de coches filtrados
     */
    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {

        return iCarRepository.getCarsByPriceLessThan(price);
    }

    /**
     * devuelve un coche dado su id
     *
     * @param codeCar id del coche
     * @return coche dado su id
     */
    @Override
    public Optional<CarDto> getCar(Integer codeCar) {
        return iCarRepository.getCar(codeCar);
    }

    /**
     * guarda un nuevo coche
     *
     * @param newCar coche a guardar
     * @return coche guardado
     */
    @Override
    public CarDto save(CarDto newCar) {
        return iCarRepository.save(newCar);
    }

    /**
     * actualiza coche
     *
     * @param carUpdated coche a actualizar
     * @return coche actualizado
     */
    @Override
    public Optional<CarDto> update(CarDto carUpdated) {
        if (iCarRepository.getCar(carUpdated.getCodeCar()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iCarRepository.save(carUpdated));
    }

    /**
     * elimina un coche dado un id
     *
     * @param codeCar id del coche a eliminar
     * @return coche eliminado
     */
    @Override
    public boolean delete(Integer codeCar) {
        if (iCarRepository.getCar(codeCar).isEmpty()) {
            return false;
        }
        iCarRepository.delete(codeCar);
        return true;
    }
}
