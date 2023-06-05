package com.proyect.coches.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarPurchaseResponseDto {

    private String referenceCar;
    private Integer quantity;
    private Integer total;
}
