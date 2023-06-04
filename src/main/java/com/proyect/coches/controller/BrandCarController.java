package com.proyect.coches.controller;

import com.proyect.coches.domain.dto.BrandCarDto;
import com.proyect.coches.domain.useCase.IBrandUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador Rest de Marca Coche
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/brands-car")
public class BrandCarController {

    /**
     * Servicio de marca coche
     */
    private final IBrandUseCase iBrandCarService;

    /**
     * Devuelve lista de marca coches
     * @return HttpStatus ook
     */
    @GetMapping
    public ResponseEntity<List<BrandCarDto>> getAll() {
        return ResponseEntity.ok(iBrandCarService.getAll());
    }

    /**
     * Devuelve una marca coche dado su id
     * @param id de la marca coche a buscar
     * @return HttpStatus Ok si la encuentra , HtppStatus not found de lo contrario
     */
    @Operation(description = "Búsqueda de las marcas de un coche")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "OK"),
            @ApiResponse(responseCode = "404",description = "Brand Car Not found")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getBrandCar(@Parameter(description = "Id de la marca coche", example = "17") @PathVariable Integer id) {
        return iBrandCarService.getBrandCar(id)
                .map(brandCarPojo -> new ResponseEntity<>(brandCarPojo,HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
        //return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    /**
     * Crea una nueva marca coche
      * @param brandCarDto Marca coche a crear
     * @return HttpStatus created si la guarda correctamente, HttpStatus de lo contrario
     */
    @PostMapping
    public ResponseEntity<BrandCarDto> save(@RequestBody BrandCarDto brandCarDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarDto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    /**
     * Actualiza una marca coche
     * @param brandCarDtoUpdate Marca coche actualizada
     * @return HttpStatus OK si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<BrandCarDto> update(@RequestBody BrandCarDto brandCarDtoUpdate){

        return ResponseEntity.of(iBrandCarService.update(brandCarDtoUpdate));
    }

    /**
     * Elimina una marca coche dado su id
     * @param id de la marca coche a eliminar
     * @return HttpStatus OK si la elimina, si no HttpStatus Not found
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iBrandCarService.delete(id)? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }

}
