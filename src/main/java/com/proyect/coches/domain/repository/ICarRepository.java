package com.proyect.coches.domain.repository;

import com.proyect.coches.domain.dto.BrandCarDto;
import com.proyect.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarRepository {
    List<CarDto> getAll();
    List<CarDto> getByIdBrandCar(Integer idBrandCar);
    List<CarDto> getCarsByPriceLessThan(Double price);
    Optional<CarDto> getCar(Integer idCar);
    CarDto save(CarDto newCar);
    void delete(Integer idCard);
}
