package com.example.demo.Models;

import java.util.Date;

public class Diagnose {
    private String patientNavn;
    private int cpr;
    private String diagnose;
    private String Medicin;
    private String note;
    private Date dato;

    public Diagnose(String patientNavn, int cpr, String diagnose, String medicin, String note, Date dato) {
        this.patientNavn = patientNavn;
        this.cpr = cpr;
        this.diagnose = diagnose;
        Medicin = medicin;
        this.note = note;
        this.dato = dato;
    }

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
        return Medicin;
    }

    public String getNote() {
        return note;
    }

    public Date getDato() {
        return dato;
    }
}
