package com.proyect.coches.domain.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Pojo de la Entidad MarcaCoche
 */
@Getter @Setter
public class BrandCarPojo {

    /**
     * Id de la marca
     */
    private Integer id;
    /**
     * Descripcion de la marca
     */
    private String description;
}
