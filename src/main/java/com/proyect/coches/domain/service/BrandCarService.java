package com.proyect.coches.domain.service;

import com.proyect.coches.domain.dto.BrandCarDto;
import com.proyect.coches.domain.repository.IBrandCarRepository;
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

    /**
     * Me trae una lista de marcas de coche
     *
     * @return Lista de marcas de coches
     */
    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarRepository.getAll();
    }

    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarRepository.getBrandCar(id);
    }

    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        return iBrandCarRepository.save(newBrandCar);
    }

    /**
     * Actualiza una marca coche
     *
     * @param brandCarDto Marca  coche a actualizar
     * @return un optional de la marca
     */
    @Override
    public Optional<BrandCarDto> update(BrandCarDto brandCarDto) {
        if (iBrandCarRepository.getBrandCar(brandCarDto.getId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iBrandCarRepository.save(brandCarDto));
    }

    /**
     * Elimina una marca coche dada su id
     *
     * @param idBrandCar Id de la marca coche
     * @return true si se elimina, false de lo contrario
     */
    @Override
    public boolean delete(Integer idBrandCar) {

        if (iBrandCarRepository.getBrandCar(idBrandCar).isEmpty()) {
            return false;
        }

        iBrandCarRepository.delete(idBrandCar);
        return true;

    }
}
