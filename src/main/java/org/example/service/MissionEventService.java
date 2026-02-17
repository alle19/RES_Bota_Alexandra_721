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

    public int riskScore(MissionEvent missionEvent){
        int result=0;
        switch (missionEvent.getType()){
            case EVA -> result = missionEvent.getBasePoints()+(missionEvent.getDay()*2);
            case SYSTEM_FAILURE ->  result = missionEvent.getBasePoints() - 3 - missionEvent.getDay();
            case SCIENCE ->  result = missionEvent.getBasePoints()+missionEvent.getDay()%4;
            case MEDICAL ->   result = missionEvent.getBasePoints()-(2*(missionEvent.getDay()%3));
            case COMMUNICATION ->   result = missionEvent.getBasePoints()+5;
        }
        return result;
    }
}
