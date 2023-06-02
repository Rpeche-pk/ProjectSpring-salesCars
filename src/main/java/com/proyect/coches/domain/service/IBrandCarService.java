package com.proyect.coches.domain.service;

import com.proyect.coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {
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
     * Actualiza una marca coche
     * @param brandCarDto Marca coche a actualizar
     * @return Marca coche actualizada
     */
    Optional<BrandCarDto> update(BrandCarDto brandCarDto);

    /**
     * Elimina una marca coche dada su id
     * @param idBrandCar Id de la marca coche
     * @Return true -- eliminado; false-- no eliminado
     */
    boolean delete(Integer idBrandCar);
}
