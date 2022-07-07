package com.example.mareu.service;

import com.example.mareu.model.Reunion;

import java.util.List;

public class DummyReunionApiService implements ReunionApiService {

    private List<Reunion> reunions = DummyReunionGenerator.generateReunions();


    @Override
    public List<Reunion> getReunion() {
        return reunions;
    }

    @Override
    public void deleteNeighbour(Reunion reunion) {
        reunions.remove(reunion);

    }

    @Override
    public void createReunion(Reunion reunion) {
        reunions.add(reunion);
    }
}
