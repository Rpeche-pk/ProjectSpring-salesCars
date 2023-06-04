package com.proyect.coches.domain.repository;

import com.proyect.coches.domain.dto.BrandCarDto;
import com.proyect.coches.domain.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    /**
     * Devuelve una lista con todas las clientes
     * @return List de Clientes
     */
    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerById(String cardId);

    Optional<CustomerDto> getCustomerByEmail(String email);

    CustomerDto save(CustomerDto newCustomer);

    void delete(String cardId);
}
