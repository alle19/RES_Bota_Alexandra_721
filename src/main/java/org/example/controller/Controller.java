package org.example.controller;

import org.example.model.Astronaut;
import org.example.model.AstronautStatus;
import org.example.model.MissionEvent;
import org.example.service.AstronautService;
import org.example.service.MissionEventService;
import org.example.service.SupplyService;

import java.util.List;

public class Controller {
    private final SupplyService supplyService;
    private final MissionEventService missionEventService;
    private final AstronautService astronautService;

    public Controller(SupplyService supplyService,  MissionEventService missionEventService, AstronautService astronautService) {
        this.supplyService = supplyService;
        this.missionEventService = missionEventService;
        this.astronautService = astronautService;
    }

    public void showCount() {
        System.out.println("Supplies loaded: " + supplyService.findAll().size());
        System.out.println("Events loaded: " + missionEventService.findAll().size());
        System.out.println("Astronauts loaded: " + astronautService.findAll().size());
    }

    public void showAstronauts(){
        List<Astronaut> astronauts = astronautService.findAll();
        astronauts.forEach(System.out::println);
    }

    public void showFilterAstronauts(String spacecraft, AstronautStatus status){
        List<Astronaut> astronauts = astronautService.filter(spacecraft, status);
        astronauts.forEach(System.out::println);
    }

    public void sortAstronauts(){
        List<Astronaut> astronauts = astronautService.sortedByExp();
        astronauts.forEach(System.out::println);

    }

    public void write(){
        astronautService.write("/Users/alexandrabota/Documents/RES_Bota_Alexandra_721/src/main/resources/result.txt");
    }

    public void showPoints(){
        List<MissionEvent> missionEvents = missionEventService.findAll();
        missionEvents.stream().limit(5).forEach(e -> System.out.println("Event <" + e.getId()+ "> ->" + "raw=<" +e.getBasePoints()+ "> ->computed=" + e.getBasePoints() ));
    }
}
