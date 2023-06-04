package com.proyect.coches.persistance.mapper;

import com.proyect.coches.domain.dto.CarDto;
import com.proyect.coches.persistance.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICarMapper {

    CarDto toCarDto(CarEntity carEntity);

    @Mapping(target = "brandCarEntity", ignore = true)
    CarEntity toCarEntity(CarDto carDto);

    List<CarDto> toCarsDto(List<CarEntity> carEntityList);

}
