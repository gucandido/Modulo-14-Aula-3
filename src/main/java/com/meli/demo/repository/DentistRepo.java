package com.meli.demo.repository;

import com.meli.demo.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepo extends JpaRepository<Dentist, Long> {


}
