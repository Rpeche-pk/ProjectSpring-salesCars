package com.proyect.coches.domain.service;

import com.proyect.coches.domain.dto.CustomerDto;
import com.proyect.coches.domain.dto.ResponseCustomerDto;
import com.proyect.coches.domain.repository.ICustomerRepository;
import com.proyect.coches.domain.useCase.ICustomerUseCase;
import com.proyect.coches.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;

    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public Optional<CustomerDto> getCustomerById(String cardId) {
        return iCustomerRepository.getCustomerById(cardId);
    }

    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    @Override
    public ResponseCustomerDto save(CustomerDto newCustomer) {
        //GUARDO EL LOS DATOS DEL CLIENTE Y LE AÑADIMOS LA CONTRASEÑA Y EL ACTIVO
        //ADEMAS, RETORNO LA CONTRASEÑA GENERADA
        String passwordGenerated= generateRandomPassword(8);

        if (!newCustomer.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }

        newCustomer.setPassword(passwordGenerated);
        newCustomer.setActive(1);

        iCustomerRepository.save(newCustomer);

        return new ResponseCustomerDto(passwordGenerated);
    }

    @Override
    public Optional<CustomerDto> update(CustomerDto modifyCustomer) {

        if (iCustomerRepository.getCustomerById(modifyCustomer.getCardId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(modifyCustomer));
    }

    @Override
    public boolean delete(String cardId) {
        if (iCustomerRepository.getCustomerById(cardId).isEmpty()) {
            return false;
        }

        iCustomerRepository.delete(cardId);
        return true;
    }

    // Método para generar una contraseña alfanumérica aleatoria de una longitud específica
    private String generateRandomPassword(int len)
    {
        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

}
