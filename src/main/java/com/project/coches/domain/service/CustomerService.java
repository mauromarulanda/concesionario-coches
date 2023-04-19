package com.project.coches.domain.service;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.CustomerResponseDto;
import com.project.coches.domain.repository.ICustomerRepository;
import com.project.coches.domain.useCase.ICustomerUseCase;
import com.project.coches.exception.EmailValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

/**
 * servicio del cliente
 */
@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerUseCase {

    private final ICustomerRepository iCustomerRepository;

    /**
     * devuelve una lista de clientes
     *
     * @return lista de clientes
     */
    @Override
    public List<CustomerDto> getAll() {
        return iCustomerRepository.getAll();
    }

    /**
     * devuelve un cliente dado un id
     *
     * @param carId identificador del cliente
     * @return cliente dado un id
     */
    @Override
    public Optional<CustomerDto> getCustomerByCarId(String carId) {
        return iCustomerRepository.getCustomerByCardId(carId);
    }

    /**
     * devuelve un cliente dado un email
     *
     * @param email email del cliente
     * @return cliente dado un email
     */
    @Override
    public Optional<CustomerDto> getCustomerByEmail(String email) {
        return iCustomerRepository.getCustomerByEmail(email);
    }

    /**
     * almanecena un nuevo cliente en caso de no existir
     *
     * @param newCustomer cliente a guardar
     * @return cliente guardado
     */
    @Override
    public CustomerResponseDto save(CustomerDto newCustomer) {
        //expresion regular para verificar formato del correo.
        if (!newCustomer.getEmail().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new EmailValidationException();
        }
        String passwordGenerated = generateRandomPassword(8);
        newCustomer.setPassword(passwordGenerated);
        newCustomer.setActive(1);
        iCustomerRepository.save(newCustomer);
        return new CustomerResponseDto(passwordGenerated);
    }

    /**
     * actualiza un cliente en caso de existir
     *
     * @param modifyCustomer cuerpo del cliente a modificar
     * @return cliente actualizado
     */
    @Override
    public Optional<CustomerDto> update(CustomerDto modifyCustomer) {
        if (iCustomerRepository.getCustomerByCardId(modifyCustomer.getCardId()).isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(iCustomerRepository.save(modifyCustomer));
    }

    /**
     * elimina un cliente en caso de que exista dado un id
     *
     * @param carId identificador del cliente a eliminar
     * @return cliente eliminado dado un id
     */
    @Override
    public boolean delete(String carId) {
        if (iCustomerRepository.getCustomerByCardId(carId).isEmpty()) {
            return false;
        }
        iCustomerRepository.delete(carId);
        return true;
    }

    // Método para generar una contraseña alfanumérica aleatoria de una longitud específica
    private String generateRandomPassword(int len) {
        // Rango ASCII – alfanumérico (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // cada iteración del bucle elige aleatoriamente un carácter del dado
        // rango ASCII y lo agrega a la instancia `StringBuilder`

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
