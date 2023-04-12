package com.project.coches.controller;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.service.IBrandCarService;
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
@RequestMapping(path = "/marcas-coches")
public class BrandCarController {
    /**
     * Servicio de marca coche
     */
    private final IBrandCarService iBrandCarService;

    /**
     * devuelve lista de marcas coche
     *
     * @return HttpCode con lista de marcas coche
     */
    @GetMapping()
    public ResponseEntity<List<BrandCarPojo>> getAll() {
        return ResponseEntity.ok(iBrandCarService.getAll());
        // return ResponseEntity.status(HttpStatus.)
        //        .body(iBrandCarService.getAll()); ALTERNATIVA PARA CREAR RESPONSE_ENTITY

        // return new ResponseEntity<>(iBrandCarService.getAll(), HttpStatus.OK); ALTERNATIVA PARA CREAR RESPONSE_ENTITY
    }

    /**
     * devuelve una marca coche dada su id
     *
     * @param id marca de coche a buscar
     * @return HttpCode OK si encuentra la marca de coche, NOTFOUND de lo contrario.
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable Integer id) {
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    /**
     * crea una nueva marca coche
     *
     * @param brandCarPojoNew marca coche a crear
     * @return create si la guarda exitosamente, BadRequest si no es asi.
     */
    @PostMapping
    public ResponseEntity<BrandCarPojo> save(@RequestBody BrandCarPojo brandCarPojoNew) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarPojoNew));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * actualiza una marca coche
     *
     * @param brandCarPojoUpdate marca de coche a actualizar
     * @return HttpCode OK si actualiza correctamente.
     */
    @PatchMapping
    public ResponseEntity<BrandCarPojo> update(@RequestBody BrandCarPojo brandCarPojoUpdate) {
        return ResponseEntity.of(iBrandCarService.update(brandCarPojoUpdate));
    }

    /**
     * elimina una marca coche dado su id
     *
     * @param id marca de coche a eliminar
     * @return HttpCode ok si existe y se elimina correctamente, NOTFOUND si no existe.
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
