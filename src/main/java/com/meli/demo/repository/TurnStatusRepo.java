package com.meli.demo.repository;

import com.meli.demo.entity.TurnStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnStatusRepo extends JpaRepository<TurnStatus, Long> {
}
