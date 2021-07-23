package com.meli.demo.repository;

import com.meli.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

    public List<Patient> findPatientsByTurnsDay(LocalDate date);

}
