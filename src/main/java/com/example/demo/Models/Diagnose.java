package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Diagnose {
    private String patientFornavn;
    private String patientEfternavn;
    private int cpr;
    private String diagnose;
    private String Medicin;
    private String note;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dato;

    public Diagnose(String patientFornavn, String patientEfternavn, int cpr, String diagnose,
                    String medicin, String note, String dato) {
        this.patientFornavn = patientFornavn;
        this.patientEfternavn = patientEfternavn;
        this.cpr = cpr;
        this.diagnose = diagnose;
        Medicin = medicin;
        this.note = note;
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

    public String getDiagnose() {
        return diagnose;
    }

    public String getMedicin() {
        return Medicin;
    }

    public String getNote() {
        return note;
    }

    public String getDato() {
        return dato;
    }
}
