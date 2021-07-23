package com.meli.demo.repository;

import com.meli.demo.entity.Dentist;
import com.meli.demo.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepo extends JpaRepository<Diary, Long> {

    public List<Diary> findDiariesByDentist(Dentist d);

}
