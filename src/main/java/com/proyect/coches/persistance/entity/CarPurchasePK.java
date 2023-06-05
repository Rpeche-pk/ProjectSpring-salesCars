package com.proyect.coches.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Getter @Setter
public class CarPurchasePK implements Serializable {

    @Serial
    private static final long serialVersionUID=1L;

    @Column(name = "compras_numero_factura")
    private Integer purchaseNumberBill;
    @Column(name = "coches_codigo_coche")
    private Integer codeCar;
}
