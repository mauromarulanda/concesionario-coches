package com.project.coches.controller;

import com.project.coches.domain.dto.CustomerDto;
import com.project.coches.domain.dto.ResponseCustomerDto;
import com.project.coches.domain.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private final ICustomerService iCustomerService;

    /**
     * retorna una lista de todos los clientes
     *
     * @return lista de todos los clientes
     */
    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(iCustomerService.getAll());
    }

    /**
     * retorna un cliente dado un id
     *
     * @param cardId identificador del cliente
     * @return cliente dado un id
     */
    @GetMapping(path = "/{cardId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String cardId) {
        return ResponseEntity.of(iCustomerService.getCustomerByCarId(cardId));
    }

    /**
     * retorna un cliente dado un email
     *
     * @param email identificador del cliente
     * @return cliente dado un email(ID)
     */
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.of(iCustomerService.getCustomerByEmail(email));
    }

    /**
     * guarda un nuevo cliente
     *
     * @param customerDtoNew nuevo cliente a guardar
     * @return cliente guardado
     */
    @PostMapping
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDtoNew) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCustomerService.save(customerDtoNew));
    }

    /**
     * actualiza un cliente
     *
     * @param customerDtoUpdate cuerpo a actualizar del cliente
     * @return cliente actualizado
     */
    @PatchMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDtoUpdate) {
        return ResponseEntity.of(iCustomerService.update(customerDtoUpdate));
    }

    /**
     * elimina un cliente dado un id
     *
     * @param cardId id del cliente a eliminar
     * @return cliente eliminado
     */
    @DeleteMapping(path = "/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardId) {
        return new ResponseEntity<>(this.iCustomerService.delete(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
