package com.project.coches.persistence.crud;

import com.project.coches.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCrudRepository extends JpaRepository<CarEntity, Integer> {
    /**
     * query method para traer coches de una marca de coches
     * @param id id de la marca de coches
     * @return lista de coches de la marca de coches
     */
    List<CarEntity> findAllByBrandCarId(Integer id);

    /**
     * query method para traer coches de menor precio a un precio dado
     * @param price precio dado
     * @return lista de coches filtrados
     */
    List<CarEntity> findAllByPriceLessThanOrderByPriceDesc(Double price);
}
