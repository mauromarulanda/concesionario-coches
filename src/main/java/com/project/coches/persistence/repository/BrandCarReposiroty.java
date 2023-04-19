package com.project.coches.persistence.repository;

import com.project.coches.domain.dto.BrandCarDto;
import com.project.coches.domain.repository.IBrandCarRepository;

import com.project.coches.persistence.crud.IBrandCarCrudRepository;
import com.project.coches.persistence.entity.BrandCarEntity;
import com.project.coches.persistence.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio marca coche
 * @RequiredArgsConstructor crea un constructor con los atributos declarados como final, libreria lombok
 */
@RequiredArgsConstructor
@Repository
public class BrandCarReposiroty implements IBrandCarRepository {

    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    private final IBrandCarMapper iBrandCarMapper;

    /**
     * devuelve todas las marcas de coche en una lista
     *
     * @return lista de marcas de coche
     */
    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarMapper.toMarcasCocheDto(iBrandCarCrudRepository.findAll());
    }

    /**
     * devuelve una marca de coche dado su id
     *
     * @param id id de marca de coche
     * @return optional de una marca de coche encontrada
     */
    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id).
                map(iBrandCarMapper::toMarcaCocheDto);
    }

    /**
     * guarda una nueva marca de coche
     *
     * @param newBrandCar marca de coche a guardar
     * @return marca de coche guardada
     */
    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return iBrandCarMapper.toMarcaCocheDto(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /**
     * elimina una marca de coche dada un id
     *
     * @param idBrandCar id de la marca a eliminar
     */
    @Override
    public void delete(Integer idBrandCar) {
        iBrandCarCrudRepository.deleteById(idBrandCar);
    }
}
