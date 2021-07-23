package com.meli.demo.dto;

import com.meli.demo.entity.Dentist;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DentistDto {

    private String name;

    private String last_name;

    private String address;

    private String dni;

    private LocalDate birth_date;

    private String phone;

    private String email;

    private String code_mp;

    private List<DiaryDto> diarys = new ArrayList<>();

    public DentistDto(Dentist d) {
        this.name = d.getName();
        this.last_name = d.getLast_name();
        this.address = d.getAddress();
        this.dni = d.getDni();
        this.birth_date = d.getBirth_date();
        this.phone = d.getPhone();
        this.email = d.getEmail();
        this.code_mp = d.getCode_mp();

        d.getDiarys().forEach(x->this.diarys.add(DiaryDto.classToDto(x)));

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

    public String getCode_mp() {
        return code_mp;
    }

    public void setCode_mp(String code_mp) {
        this.code_mp = code_mp;
    }

    public List<DiaryDto> getDiarys() {
        return diarys;
    }

    public void setDiarys(List<DiaryDto> diarys) {
        this.diarys = diarys;
    }

    public static DentistDto classToDto(Dentist d){
        return d==null?null: new DentistDto(d);
    }
}
