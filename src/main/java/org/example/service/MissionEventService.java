package org.example.service;

import org.example.model.MissionEvent;
import org.example.repo.Repo;

import java.util.List;

public class MissionEventService {

    private final Repo missionEventRepo;

    public MissionEventService(Repo missionEventRepo) {
        this.missionEventRepo = missionEventRepo;
    }

    public List<MissionEvent> findAll(){
        return missionEventRepo.readAll();
    }
}
