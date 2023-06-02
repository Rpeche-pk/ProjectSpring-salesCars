package com.proyect.coches.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Pojo de la Entidad MarcaCoche
 */
@Getter
@Setter
@NoArgsConstructor
public class BrandCarDto {

    /**
     * Id de la marca
     */
    private Integer id;
    /**
     * Descripcion de la marca
     */
    private String description;
}
