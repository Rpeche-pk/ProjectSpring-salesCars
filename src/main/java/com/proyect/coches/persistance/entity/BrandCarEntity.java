package com.proyect.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad acceso de datos marca_coche
 */
@Getter
@Setter
@Entity
@Table(name = "marca_coche")
public class BrandCarEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String description;

    @OneToMany(mappedBy = "brandCarEntity" , orphanRemoval = true)
    private List<CarEntity> carEntities;

}