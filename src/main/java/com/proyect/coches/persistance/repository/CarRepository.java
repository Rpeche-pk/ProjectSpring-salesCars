package com.proyect.coches.persistance.repository;

import com.proyect.coches.domain.dto.CarDto;
import com.proyect.coches.domain.repository.ICarRepository;
import com.proyect.coches.persistance.crud.ICarCrudRepository;
import com.proyect.coches.persistance.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepository implements ICarRepository {

    private final ICarCrudRepository iCarCrudRepository;
    private final ICarMapper iCarMapper;
    @Override
    public List<CarDto> getAll() {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAll());
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idBrandCar) {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAllByBrandCarId(idBrandCar));
    }

    @Override
    public List<CarDto> getCarsByPriceLessThan(Double price) {
        return iCarMapper.toCarsDto(iCarCrudRepository.findAllByPriceLessThanEqualOrderByPriceAsc(price));
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {
         return iCarCrudRepository.findById(idCar)
                .map(iCarMapper::toCarDto);
    }

    @Override
    public CarDto save(CarDto newCar) {
        return iCarMapper
                .toCarDto(iCarCrudRepository.save(iCarMapper.toCarEntity(newCar)));
    }

    @Override
    public void delete(Integer idCard) {
        iCarCrudRepository.deleteById(idCard);
    }
}
