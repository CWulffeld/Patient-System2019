package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Diagnose {

    private String patientNavn;
    private int cpr;
    private String diagnose;
    private String medicin;
    private String note;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dato;

    public Diagnose(String patientFornavn, String patientEfternavn, int cpr, String diagnose,
                    String medicin, String note, String dato) {
        this.patientNavn = patientFornavn + " " + patientEfternavn;
        this.cpr = cpr;
        this.diagnose = diagnose;
        this.medicin= medicin;
        this.note = note;
        this.dato = dato;
    }

    public Diagnose(){}

    public String getPatientNavn() {
        return patientNavn;
    }

    public int getCpr() {
        return cpr;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public String getMedicin() {
        return medicin;
    }

    public String getNote() {
        return note;
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

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public void setMedicin(String medicin) {
        this.medicin = medicin;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
