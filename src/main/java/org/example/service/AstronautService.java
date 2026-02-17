package org.example.service;

import org.example.model.Astronaut;
import org.example.model.AstronautStatus;
import org.example.repo.Repo;

import java.util.Comparator;
import java.util.List;

public class AstronautService {

    private final Repo astronautRepo;

    public AstronautService(Repo astronautRepo) {
        this.astronautRepo = astronautRepo;
    }

    public List<Astronaut> findAll(){
        return astronautRepo.readAll();
    }

    public List<Astronaut> filter(String spacecraft, AstronautStatus status){
        List<Astronaut> astronauts = findAll();
        return astronauts.stream()
                .filter(astronaut -> astronaut.getSpacecraft().equals(spacecraft) && astronaut.getStatus().equals(status))
                .toList();
    }

    public List<Astronaut> sortedByExp(){
        List<Astronaut> astronauts = findAll();
        return astronauts.stream()
                .sorted(Comparator.comparingInt(Astronaut::getExperienceLevel).reversed().thenComparing(Comparator.comparing(Astronaut::getName)))
                .toList();
    }

    public void write(String f){
        List<Astronaut> astronauts = sortedByExp();
        String content= "";
        for(Astronaut astronaut : astronauts){
            content += astronaut.toString() + "\n";
        }
        astronautRepo.write(content,f);

    }

}
