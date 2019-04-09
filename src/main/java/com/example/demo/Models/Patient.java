package com.example.demo.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Patient {
    @Id
    private int cpr;
    private String fornavn;
    private String efternavn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date alder;
    private int højde;
    private double vægt;
    private int telefonNr;
    private String adresse;
    private String patientBeskrivelse;

    public Patient(int cpr, String fornavn, String efternavn, Date dato, int cm, double vægt, int telefonNr, String adresse, String patientBeskrivelse) {
        this.cpr = cpr;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = dato;
        this.højde = cm;
        this.vægt = vægt;
        this.telefonNr = telefonNr;
        this.adresse = adresse;
        this.patientBeskrivelse=patientBeskrivelse;
    }

    public int getCpr() {
        return cpr;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }


    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public Date getAlder() {
        return alder;
    }

    public int getHøjde() {
        return højde;
    }

    public void setHøjde(int cm) {
        this.højde = cm;
    }

    public double getVægt() {
        return vægt;
    }

    public void setVægt(double vægt) {
        this.vægt = vægt;
    }

    public int getTelefonNr() {
        return telefonNr;
    }

    public void setTelefonNr(int telefonNr) {
        this.telefonNr = telefonNr;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getPatientBeskrivelse() {
        return patientBeskrivelse;
    }

    public void setPatientBeskrivelse(String patientBeskrivelse) {
        this.patientBeskrivelse = patientBeskrivelse;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "cpr=" + cpr +
                ", navn='" + fornavn + " " + efternavn + '\'' +
                ", alder=" + alder +
                ", højde=" + højde +
                ", vægt=" + vægt +
                ", telefonNr=" + telefonNr +
                ", Adresse='" + adresse + '\'' + ""
                '}';
    }

    // private List<Patient> patientList;
}