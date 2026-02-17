package org.example.service;

import org.example.model.Supply;
import org.example.repo.Repo;

import java.util.List;

public class SupplyService {

    private final Repo supplyRepo;

    public SupplyService(Repo supplyRepo) {
        this.supplyRepo = supplyRepo;
    }

    public List<Supply> findAll(){
        return supplyRepo.readAll();
    }
}
