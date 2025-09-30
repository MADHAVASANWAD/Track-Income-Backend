package com.finance.service;

import com.finance.exception.ResourceNotFoundException;
import com.finance.model.Budget;
import com.finance.model.Pots;
import com.finance.repo.PotsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotsService {

    @Autowired
    private PotsRepo potsRepo;

    public List<Pots> getall() {
        return potsRepo.findAll();
    }

    public Pots insert(Pots t) {
        return potsRepo.save(t);
    }

    public Pots update(Pots t, long id) {
        Pots pots = potsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("pots","id",id));
        pots.setPotname(t.getPotname());
        pots.setTarget(t.getTarget());
        pots.setMoneysaved(t.getMoneysaved());
        return potsRepo.save(pots);
    }

    public Pots addmoney(long addmoney, long id) {
        Pots pots = potsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("pots","id",id));
        pots.setMoneysaved(pots.getMoneysaved() + addmoney);
        return potsRepo.save(pots);
    }

    public Pots withdraw(long withdraw, long id) {
        Pots pots = potsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("pots","id",id));
        pots.setMoneysaved(pots.getMoneysaved() - withdraw);
        return potsRepo.save(pots);
    }

    public String deleteByid(long id){
        Pots pots = potsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("pots","id",id));
        potsRepo.deleteById(id);
        return "transaction deleted...";
    }



}
