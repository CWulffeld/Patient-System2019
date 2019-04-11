package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Konsultation {

    private int konsultation_ID;
    private String patientFornavn;
    private String patientEfternavn;
    private int cpr;

    public void setPatientFornavn(String patientFornavn) {
        this.patientFornavn = patientFornavn;
    }

    public void setPatientEfternavn(String patientEfternavn) {
        this.patientEfternavn = patientEfternavn;
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

    public Konsultation(String patientFornavn,String patientEfternavn, int cpr, String beskrivelse,
                        String konklusion, String dato) {
        this.patientFornavn = patientFornavn;
        this.patientEfternavn = patientEfternavn;
        this.cpr = cpr;
        this.beskrivelse = beskrivelse;
        this.konklusion = konklusion;
        this.dato = dato;
    }

    public int getKonsultation_ID() {
        return konsultation_ID;
    }

    public void setKonsultation_ID(int konsultation_ID) {
        this.konsultation_ID = konsultation_ID;
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
