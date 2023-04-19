package com.project.coches.controller;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.useCase.IBrandCarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de Marca Coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/brand-car")
public class BrandCarController {
    /**
     * Servicio de marca coche
     */
    private final IBrandCarUseCase iBrandCarUseCase;

    /**
     * devuelve lista de marcas coche
     *
     * @return HttpCode con lista de marcas coche
     */
    @GetMapping()
    public ResponseEntity<List<BrandCarDto>> getAll() {
        return ResponseEntity.ok(iBrandCarUseCase.getAll());
    }

    /**
     * devuelve una marca coche dada su id
     *
     * @param id marca de coche a buscar
     * @return HttpCode OK si encuentra la marca de coche, NOTFOUND de lo contrario.
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarDto> getBrandCar(@PathVariable Integer id) {
        return ResponseEntity.of(iBrandCarUseCase.getBrandCar(id));
    }

    /**
     * crea una nueva marca coche
     *
     * @param brandCarDtoNew marca coche a crear
     * @return create si la guarda exitosamente, BadRequest si no es asi.
     */
    @PostMapping
    public ResponseEntity<BrandCarDto> save(@RequestBody BrandCarDto brandCarDtoNew) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarUseCase.save(brandCarDtoNew));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * actualiza una marca coche
     *
     * @param brandCarDtoUpdate marca de coche a actualizar
     * @return HttpCode OK si actualiza correctamente.
     */
    @PutMapping
    public ResponseEntity<BrandCarDto> update(@RequestBody BrandCarDto brandCarDtoUpdate) {
        return ResponseEntity.of(iBrandCarUseCase.update(brandCarDtoUpdate));
    }

    /**
     * elimina una marca coche dado su id
     *
     * @param id marca de coche a eliminar
     * @return HttpCode ok si existe y se elimina correctamente, NOTFOUND si no existe.
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(this.iBrandCarUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
