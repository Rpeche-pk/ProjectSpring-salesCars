package com.proyect.coches.persistance.mapper;

import com.proyect.coches.domain.pojo.MarcaCochePojo;
import com.proyect.coches.persistance.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
 * Mapper que transforma objetos de Entidades a pojos y viceversa
 */
@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {

    /**
     * Convierte una entidad a un pojo de marca coche
     * @param marcaEntity Entidad a convertir
     * @return Pojo Convertido
     */
    @Mapping(source ="id" ,target ="id" )
    @Mapping(source ="description" ,target ="description" )
    MarcaCochePojo toMarcaCochePojo(MarcaCocheEntity marcaEntity);

    /**
     * Convierte un pojo de a una entidad marca coche
     * @param marcaPojo Entidad a convertir
     * @return Entity Convertido
     */
    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaPojo);

    /**
     * Convierte una lista de entities de a una lista  de pojo marca coche
     * @param marcasCocheEntity Entidad a convertir
     * @return lista Convertido
     */
    List<MarcaCochePojo> toMarcasCochePojo(List<MarcaCocheEntity> marcasCocheEntity);
}
