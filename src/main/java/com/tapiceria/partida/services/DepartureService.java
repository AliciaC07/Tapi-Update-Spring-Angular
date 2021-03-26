package com.tapiceria.partida.services;

import com.tapiceria.partida.models.Departure;
import com.tapiceria.partida.repository.DepartureRepository;
import com.tapiceria.partida.repository.DirectCostRepository;
import com.tapiceria.partida.repository.IndirectCostRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class DepartureService {
    private final DepartureRepository departureRepository;
    private final DirectCostRepository directCostRepository;
    private final IndirectCostRepository indirectCostRepository;

    public DepartureService(DepartureRepository departureRepository, DirectCostRepository directCostRepository, IndirectCostRepository indirectCostRepository) {
        this.departureRepository = departureRepository;
        this.directCostRepository = directCostRepository;
        this.indirectCostRepository = indirectCostRepository;
    }

    public Iterable<Departure> findAll(){
        return departureRepository.findAllByActiveTrue();
    }
    public Departure findByName(String name){
        return departureRepository.findByNameIgnoreCaseAndActiveTrue(name)
                .orElseThrow(() -> new EntityNotFoundException("Departure was not found."));
    }

    public Departure findById(Integer id){
        return departureRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EntityNotFoundException("Departure was not found."));
    }

    @Transactional
    public Departure save(Departure departure){
        directCostRepository.save(departure.getDirectCosts());
        indirectCostRepository.saveAll(departure.getIndirectCosts());
        return departureRepository.save(departure);
    }

    @Transactional
    public Departure update(Departure departure){
        directCostRepository.save(departure.getDirectCosts());
        indirectCostRepository.saveAll(departure.getIndirectCosts());
        return departureRepository.save(departure);
    }

    @Transactional
    public Departure delete(Departure departure){
        departure.setActive(false);
        return departureRepository.save(departure);
    }
}
