package com.meli.demo.dto;

import com.meli.demo.entity.Patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDto {

    private String name;

    private String last_name;

    private String address;

    private String dni;

    private LocalDate birth_date;

    private String phone;

    private String email;

    private List<TurnDto> turns = new ArrayList<>();

    public PatientDto(Patient p) {
        this.name = p.getName();
        this.last_name = p.getLast_name();
        this.address = p.getAddress();
        this.dni = p.getDni();
        this.birth_date = p.getBirth_date();
        this.phone = p.getPhone();
        this.email = p.getEmail();

        p.getTurns().forEach(x->this.turns.add(TurnDto.classToDto(x)));

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TurnDto> getTurns() {
        return turns;
    }

    public void setTurns(List<TurnDto> turns) {
        this.turns = turns;
    }

    public static PatientDto classToDto(Patient p){
        return p==null?null:new PatientDto(p);
    }
}
