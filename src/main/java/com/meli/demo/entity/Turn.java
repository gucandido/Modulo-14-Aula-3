package com.meli.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turn")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Long idTurn;

    private LocalDate day;

    @ManyToOne
    @JoinColumn(name = "id_diary", nullable = false)
    private Diary diary;

    @ManyToOne
    @JoinColumn(name = "id_turn_status", nullable = false)
    private TurnStatus turnStatus;

    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;

    @OneToOne
    private Turn reprogramedTurn;

    public Turn() {
    }

    public Turn(LocalDate day, Diary diary, TurnStatus turnStatus, Patient patient) {
        this.day = day;
        this.diary = diary;
        this.turnStatus = turnStatus;
        this.patient = patient;
    }

    public Long getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(Long id_turn) {
        this.idTurn = id_turn;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public TurnStatus getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(TurnStatus turn_status) {
        this.turnStatus = turn_status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Turn getReprogramedTurn() {
        return reprogramedTurn;
    }

    public void setReprogramedTurn(Turn reprogramedTurn) {
        this.reprogramedTurn = reprogramedTurn;
    }
}
