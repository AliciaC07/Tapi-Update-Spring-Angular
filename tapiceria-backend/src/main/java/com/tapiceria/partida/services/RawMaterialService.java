package com.tapiceria.partida.services;

import com.tapiceria.partida.models.RawMaterial;
import com.tapiceria.partida.repository.RawMaterialRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class RawMaterialService {

    private final RawMaterialRepository rawMaterialRepository;


    public RawMaterialService(RawMaterialRepository rawMaterialRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
    }

    public Iterable<RawMaterial> findAll(){
        return rawMaterialRepository.findAllByActiveTrue();
    }

    public RawMaterial findByName(String name){
        return rawMaterialRepository.findByNameIgnoreCaseAndActiveTrue(name)
                .orElseThrow(() -> new EntityNotFoundException("Raw Material was not found."));

    }

    public RawMaterial findById(Integer id){
        return rawMaterialRepository.findByIdAndActiveTrue(id).
                orElseThrow(() -> new EntityNotFoundException("Raw Material was not found."));

    }

    @Transactional
    public RawMaterial save(RawMaterial rawMaterial){
        return rawMaterialRepository.save(rawMaterial);
    }

    @Transactional
    public RawMaterial update(RawMaterial rawMaterial){
        RawMaterial rawMaterialold = findById(rawMaterial.getId());
        rawMaterialold.setAmount(rawMaterial.getAmount());
        rawMaterialold.setCost(rawMaterial.getCost());
        rawMaterialold.setMeasureUnit(rawMaterial.getMeasureUnit());
        rawMaterialold.setSupplier(rawMaterial.getSupplier());
        return rawMaterialRepository.save(rawMaterialold);

    }

    @Transactional
    public RawMaterial delete(RawMaterial rawMaterial){
        rawMaterial.setActive(false);
        return rawMaterialRepository.save(rawMaterial);
    }


}
