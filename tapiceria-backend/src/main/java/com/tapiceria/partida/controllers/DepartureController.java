package com.tapiceria.partida.controllers;

import com.tapiceria.partida.models.Departure;
import com.tapiceria.partida.services.DepartureService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class DepartureController {

    private final DepartureService departureService;

    public DepartureController(DepartureService departureService) {
        this.departureService = departureService;
    }

    @GetMapping("/departure")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Departure> findAll(){
        return departureService.findAll();
    }

    @GetMapping("/departure/{name}")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public Departure findByName(@PathVariable String name){
        return departureService.findByName(name);
    }

    @PostMapping("/departure")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public Departure create(@Valid @RequestBody Departure departure){
        return departureService.save(departure);
    }
    @PutMapping("/departure")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public Departure update(@Valid @RequestBody Departure departure){
        return departureService.update(departure);
    }

    @DeleteMapping("/departure/{id}")
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.OK)
    public Departure delete(@PathVariable Integer id){
        Departure departure = departureService.findById(id);
        return departureService.delete(departure);
    }

}
