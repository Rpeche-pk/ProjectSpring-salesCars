package com.proyect.coches.domain.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Pojo de la Entidad MarcaCoche
 */
@Getter @Setter
public class MarcaCochePojo {

    /**
     * Id de la marca
     */
    private Integer id;
    /**
     * Descripcion de la marca
     */
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarcaCochePojo that = (MarcaCochePojo) o;
        return id.equals(that.id) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
