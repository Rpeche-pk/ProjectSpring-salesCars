package com.proyect.coches.domain.useCase;

import com.proyect.coches.domain.dto.CustomerDto;
import com.proyect.coches.domain.dto.ResponseCustomerDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface del Customer
 */
public interface ICustomerUseCase {

    /**
     * Devuelve una lista con todas las clientes
     * @return List de Clientes
     */
    List<CustomerDto> getAll();

    Optional<CustomerDto> getCustomerById(String cardId);

    Optional<CustomerDto> getCustomerByEmail(String email);

    ResponseCustomerDto save(CustomerDto newCustomer);
    Optional<CustomerDto> update(CustomerDto modifyCustomer);

    boolean delete(String cardId);
}
