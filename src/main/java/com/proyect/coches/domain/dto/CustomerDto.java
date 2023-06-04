package com.proyect.coches.domain.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDto {
    private String cardId;
    private String fullName;
    private String email;
    private Double numberCellphone;
    private Integer active;
    private String password;

}
