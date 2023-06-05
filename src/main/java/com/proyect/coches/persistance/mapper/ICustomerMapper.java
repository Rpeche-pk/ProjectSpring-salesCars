package com.proyect.coches.persistance.mapper;

import com.proyect.coches.domain.dto.CustomerDto;
import com.proyect.coches.persistance.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Mapper que transforma objetos de Entidades a pojos y viceversa
 */
@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    CustomerDto toCustomerDto(CustomerEntity customerEntity);
    @Mapping(target = "purchaseEntity", ignore = true)
    CustomerEntity toCustomerEntity(CustomerDto customerDto);
    List<CustomerDto> toCustomersDto(List<CustomerEntity> customerEntityList);

}
