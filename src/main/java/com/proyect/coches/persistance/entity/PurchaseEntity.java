package com.proyect.coches.persistance.entity;

import com.proyect.coches.domain.dto.CarPurchaseRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "compras")
@Entity
@Getter
@Setter
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_facturas")
    private Integer numberBill;

    @Column(name = "cliente_cedula")
    private String cardIdCustomer;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

    private Double total;

    @Column(name = "medio_pago")
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "cliente_cedula", insertable = false, updatable = false)
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "purchaseEntity", cascade = CascadeType.ALL)
    private List<CarPurchaseEntity> carsPurchase;
}
