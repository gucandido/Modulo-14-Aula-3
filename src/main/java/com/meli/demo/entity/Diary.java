package com.meli.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "diary")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_diary;

    private LocalDateTime start_time;
    private LocalDateTime ending_time;

    @ManyToOne
    @JoinColumn(name = "id_dentist", nullable = false)
    private Dentist dentist;

    @OneToMany(mappedBy = "idTurn")
    private List<Turn> turns;

    public Diary() {
    }

    public Diary(LocalDateTime start_time, LocalDateTime ending_time, Dentist dentist) {
        this.start_time = start_time;
        this.ending_time = ending_time;
        this.dentist = dentist;
    }

    public Long getId_diary() {
        return id_diary;
    }

    public void setId_diary(Long id_diary) {
        this.id_diary = id_diary;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnding_time() {
        return ending_time;
    }

    public void setEnding_time(LocalDateTime ending_time) {
        this.ending_time = ending_time;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }
}
