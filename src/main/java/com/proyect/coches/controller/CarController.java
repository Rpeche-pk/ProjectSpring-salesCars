package com.proyect.coches.controller;

import com.proyect.coches.domain.dto.CarDto;
import com.proyect.coches.domain.useCase.ICarUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cars")
public class CarController {

    private final ICarUseCase iCarUseCase;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAll() {
        return ResponseEntity.ok(iCarUseCase.getAll());
    }

    @GetMapping(path = "/brand-car/{idBrandCar}")
    public ResponseEntity<?> getCustomerByCardId(@PathVariable Integer idBrandCar) {
        return ResponseEntity.ok(iCarUseCase.getByIdBrandCar(idBrandCar));

    }

    @GetMapping(path = "/price/{priceCar}")
    public ResponseEntity<?> getCarsByPriceLessThan(@PathVariable Double priceCar) {
        return ResponseEntity.ok(iCarUseCase.getCarsByPriceLessThan(priceCar));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCar(@PathVariable Integer id) {
        return iCarUseCase.getCar(id)
                .map(carDto -> new ResponseEntity<>(carDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarDto carDtoNew) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iCarUseCase.save(carDtoNew));

    }

    @DeleteMapping(path = "/{cardId}")
    public ResponseEntity<?> delete(@PathVariable Integer cardId) {
        return new ResponseEntity<>(this.iCarUseCase.delete(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
