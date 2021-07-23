package com.meli.demo.dto;
import com.meli.demo.entity.Turn;


import java.time.LocalDate;

public class TurnDto {

    private LocalDate day;

    private String dentist;

    private String patient;

    private String turnStatus;

    private TurnDto reprogramedTurn;

    public TurnDto(Turn t) {
        this.day = t.getDay();
        this.turnStatus = t.getTurnStatus().getDescription();
        this.dentist = t.getDiary().getDentist().getName() + " " + t.getDiary().getDentist().getLast_name();
        this.patient = t.getPatient().getName() + " " + t.getPatient().getLast_name();
        this.reprogramedTurn = classToDto(t.getReprogramedTurn());
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(String turnStatus) {
        this.turnStatus = turnStatus;
    }

    public TurnDto getReprogramedTurn() {
        return reprogramedTurn;
    }

    public void setReprogramedTurn(TurnDto reprogramedTurn) {
        this.reprogramedTurn = reprogramedTurn;
    }

    public String getDentist() {
        return dentist;
    }

    public void setDentist(String dentist) {
        this.dentist = dentist;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public static TurnDto classToDto(Turn t){
        return t==null?null:new TurnDto(t);
    }

}
