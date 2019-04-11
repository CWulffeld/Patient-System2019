package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Konsultation {
    private String patientFornavn;
    private String patientEfternavn;
    private int cpr;
    private String beskrivelse;
    private String konklusion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dato;

    public Konsultation(String patientFornavn,String patientEfternavn, int cpr, String beskrivelse,
                        String konklusion, String dato) {
        this.patientFornavn = patientFornavn;
        this.patientEfternavn = patientEfternavn;
        this.cpr = cpr;
        this.beskrivelse = beskrivelse;
        this.konklusion = konklusion;
        this.dato = dato;
    }

    public String getPatientFornavn() {
        return patientFornavn;
    }

    public String getPatientEfternavn(){
        return patientEfternavn;
    }

    public int getCpr() {
        return cpr;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public String getKonklusion() {
        return konklusion;
    }

    public String getDato() {
        return dato;
    }
}
