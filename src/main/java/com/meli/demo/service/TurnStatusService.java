package com.meli.demo.service;

import com.meli.demo.entity.TurnStatus;
import com.meli.demo.repository.TurnStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnStatusService {

    @Autowired
    private TurnStatusRepo repository;

    public TurnStatusService(TurnStatusRepo repository) {
        this.repository = repository;
    }

    public void saveTurnStatus(TurnStatus status){
        repository.save(status);
    }

    public void deletePatient(Long id){
        repository.deleteById(id);
    }

    public List<TurnStatus> getAll(){
        return repository.findAll();
    }

    public TurnStatus getById(Long id){
        return repository.findById(id).orElse(null);
    }

}
