package com.proyect.coches.persistance.repository;

import com.proyect.coches.domain.dto.BrandCarDto;
import com.proyect.coches.domain.repository.IBrandCarRepository;
import com.proyect.coches.persistance.entity.BrandCarEntity;
import com.proyect.coches.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio marca coche
 */
@RequiredArgsConstructor
@Repository
public class BranCarRepository implements IBrandCarRepository {

    private final IBrandCarCrudRepository iBrandCarCrudRepository;
    private final IBrandCarMapper iBrandCarMapper;

    /**
     *
      * Devuelve una lista con todas las marcas de coches
     *  @return List<BrandCarPojo>
     */
    @Override
    public List<BrandCarDto> getAll() {

        return iBrandCarMapper.toMarcasCochePojo(iBrandCarCrudRepository.findAll());
    }


    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id)
                .map(iBrandCarMapper::toMarcaCochePojo);
    }

    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {
        //Programacion funcional
        /*Function<BrandCarPojo, BrandCarEntity> brandCarEntity = iBrandCarMapper::toMarcaCocheEntity;
        //BrandCarEntity apply = brandCarEntity.apply(newBrandCar);
        //iBrandCarCrudRepository.save(apply);*/
        BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return iBrandCarMapper.toMarcaCochePojo(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /**
     * Elimina una marca coche dada su id
     * @param idBrandCar Id de la marca coche
     */
    @Override
    public void delete(Integer idBrandCar) {
        iBrandCarCrudRepository.deleteById(idBrandCar);
    }
}
