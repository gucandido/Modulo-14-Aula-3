package com.meli.demo.service;

import com.meli.demo.entity.Turn;
import com.meli.demo.repository.TurnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnService {

    @Autowired
    private TurnRepo repository;

    public TurnService(TurnRepo repository) {
        this.repository = repository;
    }

    public void saveTurn(Turn turn){
        repository.save(turn);
    }

    public void deleteTurn(Long id){
        repository.deleteById(id);
    }

    public List<Turn> getAll(){
        return repository.findAll();
    }

    public List<Turn> getFinalizedTurns(){
        return repository.findTurnsByTurnStatusNameEquals("CONCLUIDO");
    }

    public List<Turn> getOneDayPendentTurns(){
        return repository.findTurnsByDayBeforeAndTurnStatusNameEquals(LocalDate.now(),"PENDENTE");
    }

    public Turn getById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Turn> getAllReprogrammed(){
        return repository.findReprogrammedTurns();
    }

    public List<Turn> getAllReprogrammedByDentist(Long id){
        return repository.findReprogrammedTurnsByDentist(id);
    }

}
