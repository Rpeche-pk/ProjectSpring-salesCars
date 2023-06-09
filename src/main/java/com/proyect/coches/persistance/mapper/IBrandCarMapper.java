package com.proyect.coches.persistance.mapper;

import com.proyect.coches.domain.dto.BrandCarDto;
import com.proyect.coches.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper que transforma objetos de Entidades a pojos y viceversa
 */
@Mapper(componentModel = "spring")
public interface IBrandCarMapper {


    /**
     * Convierte una entidad a un pojo de marca coche
     *
     * @param marcaEntity Entidad a convertir
     * @return Pojo Convertido
     */
    //@Mapping(source = "id", target = "id")
    //@Mapping(source = "description", target = "description")
    BrandCarDto toMarcaCocheDto(BrandCarEntity marcaEntity);

    /**
     * Convierte un pojo de a una entidad marca coche
     *
     * @param marcaPojo Entidad a convertir
     * @return Entity Convertido
     */
    //@InheritInverseConfiguration
    @Mapping(target = "carEntities", ignore = true)
    BrandCarEntity toMarcaCocheEntity(BrandCarDto marcaPojo);

    /**
     * Convierte una lista de entities de a una lista  de pojo marca coche
     *
     * @param marcasCocheEntity Entidad a convertir
     * @return lista Convertido
     */
    List<BrandCarDto> toMarcasCocheDto(List<BrandCarEntity> marcasCocheEntity);
}
