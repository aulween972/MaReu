package com.example.mareu.service;

import com.example.mareu.model.Reunion;

import java.util.List;

public interface ReunionApiService {

    List<Reunion> getReunion();


    void deleteNeighbour(Reunion reunion);


    void createReunion(Reunion reunion);
}
