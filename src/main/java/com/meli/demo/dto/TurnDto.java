package com.meli.demo.dto;
import com.meli.demo.entity.Turn;
import org.springframework.lang.Nullable;


import java.time.LocalDate;

public class TurnDto {

    private LocalDate day;

    private String turnStatus;

    private TurnDto reprogramedTurn;

    public TurnDto(Turn t) {
        this.day = t.getDay();
        this.turnStatus = t.getTurnStatus().getDescription();
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

    public static TurnDto classToDto(Turn t){
        return t==null?null:new TurnDto(t);
    }

}
