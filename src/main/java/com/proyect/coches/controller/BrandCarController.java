package com.proyect.coches.controller;

import com.proyect.coches.domain.pojo.BrandCarPojo;
import com.proyect.coches.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final IBrandCarService iBrandCarService;

    /**
     * Devuelve lista de marca coches
     * @return HttpStatus ook
     */
    @GetMapping
    public ResponseEntity<List<BrandCarPojo>> getAll() {
        return ResponseEntity.ok(iBrandCarService.getAll());
    }

    /**
     * Devuelve una marca coche dado su id
     * @param id de la marca coche a buscar
     * @return HttpStatus Ok si la encuentra , HtppStatus not found de lo contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getBrandCar(@PathVariable Integer id) {
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    /**
     * Crea una nueva marca coche
      * @param brandCarPojo Marca coche a crear
     * @return HttpStatus created si la guarda correctamente, HttpStatus de lo contrario
     */
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

    /**
     * Actualiza una marca coche
     * @param brandCarPojoUpdate Marca coche actualizada
     * @return HttpStatus OK si la actualiza correctamente
     */
    @PatchMapping
    public ResponseEntity<BrandCarPojo> update(@RequestBody BrandCarPojo brandCarPojoUpdate){

        return ResponseEntity.of(iBrandCarService.update(brandCarPojoUpdate));
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
