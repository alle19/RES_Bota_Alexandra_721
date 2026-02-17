package org.example;

import org.example.controller.Controller;
import org.example.model.Astronaut;
import org.example.model.AstronautStatus;
import org.example.model.MissionEvent;
import org.example.model.Supply;
import org.example.repo.Repo;
import org.example.service.AstronautService;
import org.example.service.MissionEventService;
import org.example.service.SupplyService;

public class Main {
    static void main() {
        Repo<Astronaut> astronautRepository = new Repo<Astronaut>("/Users/alexandrabota/Documents/RES_Bota_Alexandra_721/src/main/resources/astronauts.json", Astronaut[].class);
        Repo<Supply> supplyRepository = new Repo<Supply>("/Users/alexandrabota/Documents/RES_Bota_Alexandra_721/src/main/resources/supplies.json", Supply[].class);
        Repo<MissionEvent> missionEventRepository = new Repo<MissionEvent>("/Users/alexandrabota/Documents/RES_Bota_Alexandra_721/src/main/resources/events.json", MissionEvent[].class);

        SupplyService supplyService = new SupplyService(supplyRepository);
        AstronautService astronautService = new AstronautService(astronautRepository);
        MissionEventService missionEventService = new MissionEventService(missionEventRepository);

        Controller controller = new Controller(supplyService, missionEventService, astronautService);

        controller.showCount();
        controller.showAstronauts();
        System.out.println("filtrati:");
        controller.showFilterAstronauts( "Orion", AstronautStatus.ACTIVE);
        System.out.println();
        System.out.println("sortati:");
        controller.sortAstronauts();
        controller.write();
        System.out.println("ex 5:");
        controller.showPoints();
    }
}    
