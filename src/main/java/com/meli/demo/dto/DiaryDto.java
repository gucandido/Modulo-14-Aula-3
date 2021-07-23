package com.meli.demo.dto;

import com.meli.demo.entity.Diary;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DiaryDto {

    private LocalDateTime start_time;
    private LocalDateTime ending_time;

    private List<TurnDto> turns = new ArrayList<>();

    public DiaryDto(Diary d) {
        this.start_time = d.getStart_time();
        this.ending_time = d.getEnding_time();
        d.getTurns().forEach(x->this.turns.add(TurnDto.classToDto(x)));
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

    public List<TurnDto> getTurns() {
        return turns;
    }

    public void setTurns(List<TurnDto> turns) {
        this.turns = turns;
    }

    public static DiaryDto classToDto(Diary d){
        return new DiaryDto(d);
    }

}
