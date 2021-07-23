package com.meli.demo.repository;

import com.meli.demo.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepo extends JpaRepository<Turn, Long> {
}
