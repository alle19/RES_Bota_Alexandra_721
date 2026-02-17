package org.example.repo;

import tools.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repo<T>{
    private final String fileName;
    private final Class<T[]>array;
    ObjectMapper objectMapper = new ObjectMapper();
    public Repo(String fileName, Class<T[]>array){
        this.fileName = fileName;
        this.array = array;
    }

    public List<T> readAll(){
        return new ArrayList<>(Arrays.asList(objectMapper.readValue(new File(fileName), array)));
    }


    //pt ex4
    public void write(String s, String file){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(s);
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
