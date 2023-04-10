package com.proyect.coches.domain.service;

import com.proyect.coches.domain.pojo.BrandCarPojo;
import com.proyect.coches.domain.repository.IBrandCarRepository;
import com.proyect.coches.persistance.entity.BrandCarEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para el dominio marca coche
 */
@RequiredArgsConstructor
@Service
public class BrandCarService implements IBrandCarService {

    private final IBrandCarRepository iBrandCarRepository;

    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarRepository.getAll();
    }

    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }

    @Override
    public boolean delete(Integer idBrandCar) {
        try{
            iBrandCarRepository.delete(idBrandCar);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
