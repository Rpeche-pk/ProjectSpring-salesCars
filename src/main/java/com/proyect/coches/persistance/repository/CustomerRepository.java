package com.proyect.coches.persistance.repository;

import com.proyect.coches.domain.dto.CustomerDto;
import com.proyect.coches.domain.repository.ICustomerRepository;
import com.proyect.coches.persistance.crud.ICustomerCrudRepository;
import com.proyect.coches.persistance.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerRepository implements ICustomerRepository {

    private final ICustomerCrudRepository iCustomerCrudRepository;
    private final ICustomerMapper iCustomerMapper;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerMapper.toCustomersDto(iCustomerCrudRepository.findAll());
    }

    @Override
    public Optional<CustomerDto> getCustomerById(String cardId) {
        return iCustomerCrudRepository.findById(cardId)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerCrudRepository.findByEmail(email)
                .map(iCustomerMapper::toCustomerDto);
    }

    @Override
    public CustomerDto save(CustomerDto newCustomer) {

        return iCustomerMapper
                .toCustomerDto(iCustomerCrudRepository.save(iCustomerMapper.toCustomerEntity(newCustomer)));
    }

    @Override
    public void delete(String cardId) {
        iCustomerCrudRepository.deleteById(cardId);
    }
}
