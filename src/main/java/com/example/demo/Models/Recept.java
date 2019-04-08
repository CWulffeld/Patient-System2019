package com.example.demo.Models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Recept {
    private String patientNavn;
    private int cpr;
    private String note;
    private String medicin;
    private Date dato;

    public Recept(String patientNavn, int cpr, String note, String medicin, Date dato) {
        this.patientNavn = patientNavn;
        this.cpr = cpr;
        this.note = note;
        this.medicin = medicin;
        this.dato = dato;
    }

    public String getPatientNavn() {
        return patientNavn;
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

    public Date getDato() {
        return dato;
    }
}
