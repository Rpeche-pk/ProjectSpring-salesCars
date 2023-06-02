package com.proyect.coches.domain.repository;

import com.proyect.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return List<BrandCarPojo>
     */
    List<BrandCarDto> getAll();

    /**
     * Devuelve una marca de coche dada su id
     * @param id id de marca coche
     * @return Optional<BrandCarPojo>
     */
    Optional<BrandCarDto> getBrandCar(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return BrandCarPojo
     */
    BrandCarDto save(BrandCarDto newBrandCar);

    /**
     * Elimina una marca coche dada su id
     * @param idBrandCar Id de la marca coche
     */
    void delete(Integer idBrandCar);
}
