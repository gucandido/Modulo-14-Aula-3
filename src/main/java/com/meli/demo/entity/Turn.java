package com.meli.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turn")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turn;

    private LocalDate day;

    @ManyToOne
    @JoinColumn(name = "id_diary", nullable = false)
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "id_turn_status", nullable = false)
    private TurnStatus turn_status;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    public Turn() {
    }

    public Turn(LocalDate day, Diary diary, TurnStatus turn_status, Patient patient) {
        this.day = day;
        this.diary = diary;
        this.turn_status = turn_status;
        this.patient = patient;
    }

    public Long getId_turn() {
        return id_turn;
    }

    public void setId_turn(Long id_turn) {
        this.id_turn = id_turn;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    /*public Diary getDiary() {
        return diary;
    }*/

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public TurnStatus getTurn_status() {
        return turn_status;
    }

    public void setTurn_status(TurnStatus turn_status) {
        this.turn_status = turn_status;
    }

    /*public Patient getPatient() {
        return patient;
    }*/

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
