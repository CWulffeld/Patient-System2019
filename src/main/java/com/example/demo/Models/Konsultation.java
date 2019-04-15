package com.example.demo.Models;

import org.springframework.format.annotation.DateTimeFormat;


public class Konsultation {

    private String patientNavn;
    private int cpr;
    private String beskrivelse;
    private String konklusion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dato;

    public Konsultation(){}

    public Konsultation(String beskrivelse, String konklusion, String dato){
        this.beskrivelse = beskrivelse;
        this.konklusion = konklusion;
        this.dato = dato;
    }

    public Konsultation(String patientNavn, int cpr, String beskrivelse,
                        String konklusion, String dato) {
        this.patientNavn = patientNavn;
        this.cpr = cpr;
        this.beskrivelse = beskrivelse;
        this.konklusion = konklusion;
        this.dato = dato;
    }

    public String getPatientNavn() {
        return patientNavn;
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

    public void setPatientNavn(String patientFornavn, String patientEfternavn) {
        this.patientNavn = patientFornavn + " " + patientEfternavn;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setKonklusion(String konklusion) {
        this.konklusion = konklusion;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
