package com.meli.demo.service;

import com.meli.demo.entity.Dentist;
import com.meli.demo.repository.DentistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService {

    @Autowired
    private DentistRepo repository;

    public DentistService(DentistRepo repository) {
        this.repository = repository;
    }

    public void createNewDentist(Dentist dentist){
        repository.save(dentist);
    }

    public void deleteDentist(Long id){
        repository.deleteById(id);
    }

    public List<Dentist> getAll(){
        return repository.findAll();
    }

}
