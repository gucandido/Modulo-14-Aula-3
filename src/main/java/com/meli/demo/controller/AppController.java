package com.meli.demo.controller;

import com.meli.demo.dto.DentistDto;
import com.meli.demo.dto.DiaryDto;
import com.meli.demo.dto.PatientDto;
import com.meli.demo.dto.TurnDto;
import com.meli.demo.entity.*;
import com.meli.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

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

        List<DentistDto> list = new ArrayList<>();

        dentistService.getAll().forEach(x->list.add(DentistDto.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    // 1 - Listar todos os pacientes atendidos, em um dia, por todos os dentistas.
    @GetMapping("patients")
    public ResponseEntity<?> getPatients(){

        List<PatientDto> list = new ArrayList<>();

        patientService.getAllByDay(LocalDate.of(2021,Month.JULY,24)).forEach(x->list.add(PatientDto.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

    // 2 - Listar todos os dentistas que tenham mais de dois turnos em uma data
    @GetMapping("dentist/day")
    public ResponseEntity<?> getDentistsByDayHavingTwoMore(){

        List<DentistDto> list = new ArrayList<>();

        dentistService.getAllByDayHavingTwoMore(LocalDate.of(2021,Month.JULY,24)).forEach(x->list.add(DentistDto.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

    // 3 - Listar todos os turnos com status finalizado
    @GetMapping("turns/finalized")
    public ResponseEntity<?> getFinalizedTurns(){

        List<TurnDto> list = new ArrayList<>();

        turnService.getFinalizedTurns().forEach(x->list.add(TurnDto.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

    // 4 - Listar todos os turnos com estado pendente de um dia
    @GetMapping("turns/pendent")
    public ResponseEntity<?> getPendentTurns(){

        List<TurnDto> list = new ArrayList<>();

        turnService.getOneDayPendentTurns().forEach(x->list.add(TurnDto.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

    // 5 - Listar a agenda de um dentista
    @GetMapping("diarys/{idDentist}")
    public ResponseEntity<?> getDiarysByDentist(@PathVariable Long idDentist){

        List<DiaryDto> list = new ArrayList<>();

        diaryService.getAllByDentist(dentistService.getDentistById(idDentist)).forEach(x->list.add(DiaryDto.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);

    }

    // 6 - Listar todos os turnos que foram remarcados de um dentista
    @GetMapping("turns/reprogrammed/{idDentist}")
    public ResponseEntity<?> getReprogrammedTurnsByDentist(@PathVariable Long idDentist){

        List<TurnDto> list = new ArrayList<>();

        turnService.getAllReprogrammedByDentist(idDentist).forEach(x->list.add(TurnDto.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    // 7 - Listar todos os turnos que foram remarcados . (extra)
    @GetMapping("turns/reprogrammed")
    public ResponseEntity<?> getReprogrammedTurns(){

        List<TurnDto> list = new ArrayList<>();

        turnService.getAllReprogrammed().forEach(x->list.add(TurnDto.classToDto(x)));

        return new ResponseEntity<>(turnService.getAllReprogrammed(), HttpStatus.ACCEPTED);
    }

    // remarca uma consulta
    @PostMapping("turns/reprogram/{idPatient}/{idTurn}")
    public ResponseEntity<?> postReprogramTurn(@PathVariable Long idPatient,@PathVariable Long idTurn){

        Turn trOld = turnService.getById(idTurn);
        Turn trNew = new Turn(LocalDate.of(2021,Month.AUGUST,23),trOld.getDiary(),turnStatusService.getById(3L),trOld.getPatient());

        trOld.setTurnStatus(turnStatusService.getById(2L));
        trNew.setReprogramedTurn(trOld);

        turnService.saveTurn(trOld);
        turnService.saveTurn(trNew);

        return new ResponseEntity<>("ok", HttpStatus.CREATED);

    }

    // inicializa o banco de dados com os dados para os testes
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
        Turn tr2 = new Turn(LocalDate.of(2021,Month.JULY,22),dr1,t3,p2);
        Turn tr3 = new Turn(LocalDate.of(2021,Month.JULY,24),dr1,t1,p3);
        Turn tr4 = new Turn(LocalDate.of(2021,Month.JULY,22),dr1,t2,p3);

        diaryService.createNewDiary(dr1);
        turnService.saveTurn(tr1);
        turnService.saveTurn(tr2);
        turnService.saveTurn(tr3);
        turnService.saveTurn(tr4);

        return new ResponseEntity<>("ok", HttpStatus.CREATED);

    }




}