package com.tapiceria.partida.controllers;

import com.tapiceria.partida.models.RawMaterial;
import com.tapiceria.partida.services.RawMaterialService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class RawMaterialController {
    private final RawMaterialService rawMaterialService;

    public RawMaterialController(RawMaterialService rawMaterialService) {
        this.rawMaterialService = rawMaterialService;
    }

    @GetMapping("/departure/raw_material")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<RawMaterial> findAll(){
        return rawMaterialService.findAll();
    }

    @GetMapping("/departure/raw_material/{name}")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public RawMaterial findByName(@PathVariable String name){
        return rawMaterialService.findByName(name);
    }

    @GetMapping("/departure/raw_material/{id}")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public RawMaterial findById(@PathVariable Integer id){
        return rawMaterialService.findById(id);
    }

    @PostMapping("/departure/raw_material")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public RawMaterial create(@Valid @RequestBody RawMaterial rawMaterial){
        return rawMaterialService.save(rawMaterial);
    }

    @PutMapping("/departure/raw_material")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public RawMaterial update(@Valid @RequestBody RawMaterial rawMaterial){
        return rawMaterialService.save(rawMaterial);
    }

    @DeleteMapping("/departure/raw_material/{id}")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public RawMaterial delete(@PathVariable Integer id){
        RawMaterial rawMaterial = rawMaterialService.findById(id);
        return rawMaterialService.delete(rawMaterial);
    }


}
