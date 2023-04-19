package com.project.coches.persistence.repository;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.repository.ICarRepository;
import com.project.coches.persistence.crud.ICarCrudRepository;
import com.project.coches.persistence.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CarRepository implements ICarRepository {

    private final ICarCrudRepository iCarCrudRepository;
    private final ICarMapper iCarMapper;

    /**
     * devuelve una lista de los coches
     *
     * @return lista de los coches
     */
    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAll());
    }

    /**
     * devuele un coche dado un id
     *
     * @param codeCar id del coche
     * @return coche dado el id
     */
    @Override
    public Optional<CarDto> getCar(Integer codeCar) {
        return iCarCrudRepository.findById(codeCar).map(
                iCarMapper::toCarDto);
    }

    /**
     * devuelve lista de coches dado el id de la marca
     *
     * @param brandCarId id de la marca
     * @return lista de coches de la marca
     */
    @Override
    public List<CarDto> getByIdBrandCar(Integer brandCarId) {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAllByBrandCarId(brandCarId));
    }

    /**
     * lista de coches menores a un precio dado
     *
     * @param price precio dado
     * @return lista de coches filtrados
     */
    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAllByPriceLessThanOrderByPriceDesc(price));
    }

    /**
     * guarda un nuevo coche
     *
     * @param newCar coche a guardar
     * @return coche guardado
     */
    @Override
    public CarDto save(CarDto newCar) {
        return iCarMapper.toCarDto(
                iCarCrudRepository.save(iCarMapper.toCarEntity(newCar)));
    }

    /**
     * elimina un coche dado el id
     *
     * @param codeCar id del coche a eliminar
     */
    @Override
    public void delete(Integer codeCar) {
        iCarCrudRepository.deleteById(codeCar);
    }
}
