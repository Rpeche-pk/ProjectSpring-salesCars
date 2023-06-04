package com.proyect.coches.persistance.crud;

import com.proyect.coches.persistance.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCrudRepository extends JpaRepository<CarEntity,Integer> {

    //Query Method
    List<CarEntity> findAllByBrandCarId(Integer id);
    List<CarEntity> findAllByPriceLessThanEqualOrderByPriceAsc(Double price);


}
