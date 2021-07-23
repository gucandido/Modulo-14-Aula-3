package com.meli.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "turn_status")
public class TurnStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turn_status;

    private String name;

    private String description;

    @OneToMany(mappedBy = "turn_status")
    private List<Turn> turns;

    public TurnStatus() {
    }

    public TurnStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId_turn_status() {
        return id_turn_status;
    }

    public void setId_turn_status(Long id_turn_status) {
        this.id_turn_status = id_turn_status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }
}
