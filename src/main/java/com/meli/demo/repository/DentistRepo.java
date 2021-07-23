package com.meli.demo.repository;

import com.meli.demo.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DentistRepo extends JpaRepository<Dentist, Long> {

    @Query("select d " +
            "from Dentist d join Diary dr on d.id_dentist = dr.dentist.id_dentist " +
                            "join Turn t on dr.id_diary = t.diary.id_diary " +
            "where t.day = :day " +
            "group by d " +
            "having count(d) > 2")
    public List<Dentist> findDentistsByTurnsDayHavingTwoMore(@Param("day") LocalDate day);

}
