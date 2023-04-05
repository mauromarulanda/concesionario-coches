package com.project.coches.persistence.repository;


import com.project.coches.persistence.entity.BrandCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandCarCrudRepository extends JpaRepository<BrandCarEntity, Integer> {

}
