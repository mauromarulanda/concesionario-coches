package com.project.coches.controller;

import com.project.coches.domain.dto.CarDto;
import com.project.coches.domain.useCase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controlador de coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cars")
public class CarController {

    private final ICarUseCase iCarUseCase;

    /**
     * devuelve una lista de todos los coches
     * @return lista de coches
     */
    @GetMapping()
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(iCarUseCase.getAll());
    }

    /**
     * devuelve un coche dado su id
     * @param codeCar id del coche
     * @return coche dado su id
     */
    @GetMapping(path = "/{codeCar}")
    public ResponseEntity<CarDto> getCar(@PathVariable Integer codeCar) {
        return ResponseEntity.of(iCarUseCase.getCar(codeCar));
    }

    /**
     * lista de coches dado el id de su marca
     * @param brandCarId id de la marca
     * @return coches dado el id
     */
    @GetMapping(path = "/brand-car/{brandCarId}")
    public ResponseEntity<List<CarDto>> getByIdBrandCar(@PathVariable Integer brandCarId) {
        return ResponseEntity.ok(iCarUseCase.getByIdBrandCar(brandCarId));
    }

    /**
     * lista de coches con un costo menor a el precio dado
     * @param price precio dado
     * @return lista de coches filtrados
     */
    @GetMapping(path = "/price/{price}")
    public ResponseEntity<List<CarDto>> getCarsByPriceLessThan(@PathVariable Double price) {
        return ResponseEntity.ok(iCarUseCase.getCarsByPriceLessThan(price));
    }

    /**
     * guarda un nuevo coche
     * @param newCarDto coche a guardar
     * @return coche guardado
     */
    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarDto newCarDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCarUseCase.save(newCarDto));
    }

    /**
     * actualiza coche
     * @param carUpdated coche a actualizar
     * @return coche actualizado
     */
    @PatchMapping
    public ResponseEntity<CarDto> update(@RequestBody CarDto carUpdated) {
        return ResponseEntity.of(iCarUseCase.update(carUpdated));
    }

    /**
     * elimina un coche dado un id
     * @param codeCar id del coche a eliminar
     * @return coche eliminado
     */
    @DeleteMapping(path = "/{codeCar}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer codeCar) {
        return new ResponseEntity<>(
                this.iCarUseCase.delete(codeCar) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
