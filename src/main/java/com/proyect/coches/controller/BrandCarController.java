package com.proyect.coches.controller;

import com.proyect.coches.domain.pojo.BrandCarPojo;
import com.proyect.coches.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador Rest de Marca Coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/marcas-coches")
public class BrandCarController {

    /**
     * Servicio de marca coche
     */
    private IBrandCarService iBrandCarService;

    @GetMapping
    public ResponseEntity<List<BrandCarPojo>> getAll() {
        return ResponseEntity.ok(iBrandCarService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<BrandCarPojo>> getBrandCar(@PathVariable Integer id) {
        return ResponseEntity.of(Optional.ofNullable(iBrandCarService.getBrandCar(id)));
    }

    @PostMapping
    public ResponseEntity<BrandCarPojo> save(@RequestBody BrandCarPojo brandCarPojo){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarPojo));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

}
