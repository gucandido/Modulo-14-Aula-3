package com.meli.demo.service;

import com.meli.demo.entity.Turn;
import com.meli.demo.repository.TurnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnService {

    @Autowired
    private TurnRepo repository;

    public TurnService(TurnRepo repository) {
        this.repository = repository;
    }

    public void createNewTurn(Turn turn){
        repository.save(turn);
    }

    public void deleteTurn(Long id){
        repository.deleteById(id);
    }

    public List<Turn> getAll(){
        return repository.findAll();
    }

}
