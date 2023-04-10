package com.proyect.coches.domain.repository;

import com.proyect.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return List<BrandCarPojo>
     */
    List<BrandCarPojo> getAll();

    /**
     * Devuelve una marca de coche dada su id
     * @param id id de marca coche
     * @return Optional<BrandCarPojo>
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return BrandCarPojo
     */
    BrandCarPojo save(BrandCarPojo newBrandCar);

    /**
     * Elimina una marca coche dada su id
     * @param idBrandCar Id de la marca coche
     */
    void delete(Integer idBrandCar);
}
