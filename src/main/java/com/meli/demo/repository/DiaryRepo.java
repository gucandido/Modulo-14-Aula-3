package com.meli.demo.repository;

import com.meli.demo.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepo extends JpaRepository<Diary, Long> {
}
