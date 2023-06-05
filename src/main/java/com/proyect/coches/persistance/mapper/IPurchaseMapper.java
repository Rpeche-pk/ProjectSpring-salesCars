package com.proyect.coches.persistance.mapper;

import com.proyect.coches.domain.dto.CarDto;
import com.proyect.coches.domain.dto.PurchaseRequestDto;
import com.proyect.coches.persistance.entity.CarEntity;
import com.proyect.coches.persistance.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPurchaseMapper {

    PurchaseRequestDto toPurchaseRequestDto(PurchaseEntity purchaseEntity);


    @Mapping(target = "customerEntity", ignore = true)
    PurchaseEntity toPurchaseEntity(PurchaseRequestDto purchaseRequestDto);

    List<PurchaseRequestDto> toPurchasesDto(List<PurchaseEntity> purchaseEntityList);
}
