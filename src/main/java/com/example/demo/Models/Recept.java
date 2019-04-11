package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Recept {
    private String patientFornavn;
    private String patientEfternavn;
    private int cpr;
    private String note;
    private String medicin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dato;

    public Recept(String patientFornavn, String patientEfternavn, int cpr, String note,
                  String medicin, String dato) {
        this.patientFornavn = patientFornavn;
        this.patientEfternavn = patientEfternavn;
        this.cpr = cpr;
        this.note = note;
        this.medicin = medicin;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMedicin() {
        return medicin;
    }

    public String getDato() {
        return dato;
    }
}
