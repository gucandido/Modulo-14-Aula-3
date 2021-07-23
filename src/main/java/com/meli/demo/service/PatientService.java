package com.meli.demo.service;

import com.meli.demo.entity.Patient;
import com.meli.demo.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo repository;

    public PatientService(PatientRepo repository) {
        this.repository = repository;
    }

    public void createNewPatient(Patient patient){
        repository.save(patient);
    }

    public void deletePatient(Long id){
        repository.deleteById(id);
    }

    public List<Patient> getAll(){
        return repository.findAll();
    }

}
