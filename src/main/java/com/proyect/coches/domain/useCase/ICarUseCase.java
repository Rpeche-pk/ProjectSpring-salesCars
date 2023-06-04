package com.proyect.coches.domain.useCase;


import com.proyect.coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarUseCase {

    List<CarDto> getAll();
    List<CarDto> getByIdBrandCar(Integer idCar);
    List<CarDto> getCarsByPriceLessThan(Double price);
    Optional<CarDto> getCar(Integer idCar);
    CarDto save(CarDto newCar);
    boolean delete(Integer idCard);

}
