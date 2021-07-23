package com.meli.demo.controller;

import com.meli.demo.entity.*;
import com.meli.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Controller
@RequestMapping("/")
public class TestController {

    @Autowired
    private DentistService dentistService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private TurnStatusService turnStatusService;

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private TurnService turnService;

    @GetMapping("dentist")
    public ResponseEntity<?> getDentists(){
        return new ResponseEntity<>(dentistService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("patients")
    public ResponseEntity<?> getPatients(){
        return new ResponseEntity<>(patientService.getAllByDay(LocalDate.of(2021,Month.JULY,24)), HttpStatus.ACCEPTED);
    }

    @GetMapping("dentist/day")
    public ResponseEntity<?> getDentistsByDayHavingTwoMore(){
        return new ResponseEntity<>(dentistService.getAllByDayHavingTwoMore(LocalDate.of(2021,Month.JULY,24)), HttpStatus.ACCEPTED);
    }

    @PostMapping("post")
    public ResponseEntity<?> postDatabaseInit(){

        System.out.println("database init");

        /* criacao dos dentistas */
        Dentist d1 = new Dentist("Francisco","Tiradentes","Minas Gerais","oshee",LocalDate.of(1892, Month.APRIL, 14),"+553598787521","","A123456a");
        Dentist d2 = new Dentist("Celso","Rodriguez","São Caetano do Sul","oshee",LocalDate.of(1992, Month.AUGUST, 5),"+551696887421","celso.coringao@hotmail.com","B123456b");

        dentistService.createNewDentist(d1);
        dentistService.createNewDentist(d2);

        System.out.println("database - dentist");

        /* criacao dos pacientes */
        Patient p1 = new Patient("Joao","Ghordo", "Pirapitingui - SP", "oshee", LocalDate.of(1994, Month.AUGUST, 5), "+551598857431","jao.gordasso@gmail.com");
        Patient p2 = new Patient("Felipe","Farias", "Caetité - BA", "oshee", LocalDate.of(1994, Month.SEPTEMBER, 5), "+556998857431","f.farias@outlook.com");
        Patient p3 = new Patient("Beatriz","Knusty", "Criciúma - SC", "oshee", LocalDate.of(1995, Month.JULY, 5), "+554898857431","bia_htinha15@hotmail.com");

        patientService.createNewPatient(p1);
        patientService.createNewPatient(p2);
        patientService.createNewPatient(p3);

        System.out.println("database - patient");

        /* criacao dos status de turno */
        TurnStatus t1 = new TurnStatus("CONCLUIDO","Concluído");
        TurnStatus t2 = new TurnStatus("CANCELADO","Cancelado");
        TurnStatus t3 = new TurnStatus("PENDENTE","Pendente");

        turnStatusService.createNewStatus(t1);
        turnStatusService.createNewStatus(t2);
        turnStatusService.createNewStatus(t3);

        System.out.println("database - status");

        Diary dr1 = new Diary(LocalDateTime.of(2021,Month.JULY,24,15,30),LocalDateTime.of(2021,Month.JULY,24,16,00),d1);

        Turn tr1 = new Turn(LocalDate.of(2021,Month.JULY,24),dr1,t3,p1);
        Turn tr2 = new Turn(LocalDate.of(2021,Month.JULY,24),dr1,t3,p2);

        diaryService.createNewDiary(dr1);
        turnService.createNewTurn(tr1);
        turnService.createNewTurn(tr2);

        return new ResponseEntity<>("ok", HttpStatus.ACCEPTED);

    }




}
