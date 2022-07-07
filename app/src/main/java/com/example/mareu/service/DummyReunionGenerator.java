package com.example.mareu.service;

import com.example.mareu.model.Reunion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public abstract class DummyReunionGenerator {

    public static List<Reunion> DUMMY_REUNION = Arrays.asList(

            new Reunion("Reunion", new Date(), "Paris", "Aulween")

    );

    public static List<Reunion> generateReunions() {
        return new ArrayList<>(DUMMY_REUNION);
    }
}
