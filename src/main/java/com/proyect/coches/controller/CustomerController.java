package com.proyect.coches.controller;

import com.proyect.coches.domain.dto.CustomerDto;
import com.proyect.coches.domain.dto.ResponseCustomerDto;
import com.proyect.coches.domain.useCase.ICustomerUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerUseCase iCustomerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(iCustomerService.getAll());
    }

    @Operation(description = "Búsqueda de las marcas de un coche")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Brand Car Not found")
    })
    @GetMapping(path = "/{cardId}")
    public ResponseEntity<?> getCustomerByCardId(@Parameter(description = "Id de la marca coche", example = "17") @PathVariable String cardId) {
        return iCustomerService.getCustomerById(cardId)
                .map(customerDto -> new ResponseEntity<>(customerDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(description = "Búsqueda del cliemte dado su email")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Email Not found")
    })
    @GetMapping(path = "/{email}")
    public ResponseEntity<?> getCustomerByEmail(@PathVariable String email) {
        return iCustomerService.getCustomerByEmail(email)
                .map(customerDto -> new ResponseEntity<>(customerDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCustomerService.save(customerDto));

    }

    @PatchMapping
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDtoUpdate) {

        return ResponseEntity.of(iCustomerService.update(customerDtoUpdate));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return new ResponseEntity<>(this.iCustomerService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
