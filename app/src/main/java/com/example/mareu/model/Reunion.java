package com.example.mareu.model;

import java.util.Date;

public class Reunion {
    private String subject;
    private Date time;
    private String place;
    private String person;

    Reunion(String subject, Date time, String place, String person) {

        this.subject = subject;
        this.time = time;
        this.place = place;
        this.person = person;

    }

    public String getSubject() {
        return subject;
    }

    public Date getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getPerson() {
        return person;
    }
}
