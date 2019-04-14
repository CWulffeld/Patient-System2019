package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Recept {
    private String patientNavn;
    private int cpr;
    private String note;
    private String medicin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dato;

    public Recept(String patientFornavn, String patientEfternavn, int cpr, String note,
                  String medicin, String dato) {
        this.patientNavn = patientFornavn + " " + patientEfternavn;
        this.cpr = cpr;
        this.note = note;
        this.medicin = medicin;
        this.dato = dato;
    }

    public Recept(){}

    public String getPatientNavn() {
        return patientNavn;
    }

    public int getCpr() {
        return cpr;
    }

    public String getNote() {
        return note;
    }

    public String getMedicin() {
        return medicin;
    }

    public String getDato() {
        return dato;
    }

    public void setPatientNavn(String patientFornavn, String patientEfternavn){
        patientNavn = patientFornavn + " " + patientEfternavn;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public void setMedicin(String medicin) {
        this.medicin = medicin;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
