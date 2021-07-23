package com.meli.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "dentist")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentist")
    private Long idDentist;

    private String name;

    private String last_name;

    private String address;

    private String dni;

    private LocalDate birth_date;

    private String phone;

    private String email;

    private String code_mp;

    @OneToMany(mappedBy = "dentist")
    private List<Diary> diarys;

    public Dentist() {

    }

    public Dentist(String name, String last_name, String address, String dni, LocalDate birth_date, String phone, String email, String code_mp) {
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.dni = dni;
        this.birth_date = birth_date;
        this.phone = phone;
        this.email = email;
        this.code_mp = code_mp;
    }

    public Long getIdDentist() {
        return idDentist;
    }

    public void setIdDentist(Long id_dentist) {
        this.idDentist = id_dentist;
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

    public List<Diary> getDiarys() {
        return diarys;
    }

    public void setDiarys(List<Diary> diarys) {
        this.diarys = diarys;
    }
}
