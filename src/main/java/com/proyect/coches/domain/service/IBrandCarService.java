package com.proyect.coches.domain.service;

import com.proyect.coches.domain.pojo.BrandCarPojo;
import com.proyect.coches.persistance.entity.BrandCarEntity;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {
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
     * Actualiza una marca coche
     * @param brandCarPojo Marca coche a actualizar
     * @return Marca coche actualizada
     */
    Optional<BrandCarPojo> update(BrandCarPojo brandCarPojo);

    /**
     * Elimina una marca coche dada su id
     * @param idBrandCar Id de la marca coche
     * @Return true -- eliminado; false-- no eliminado
     */
    boolean delete(Integer idBrandCar);
}
