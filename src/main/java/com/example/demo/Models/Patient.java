package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Patient {

    private List<Patient> patientList;

    @Id
    private int cpr;
    private String forNavn;
    private String efterNavn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private DateTimeFormat fødselsdato;
    private int højde;
    private int vægt;
    private int telefonNr;

    public void setFødselsdato(DateTimeFormat fødselsdato) {
        this.fødselsdato = fødselsdato;
    }

    public String getKortBeskrivelse() {
        return kortBeskrivelse;
    }

    public void setKortBeskrivelse(String kortBeskrivelse) {
        this.kortBeskrivelse = kortBeskrivelse;
    }

    private String kortBeskrivelse;

    public String getForNavn() {
        return forNavn;
    }

    public void setForNavn(String forNavn) {
        this.forNavn = forNavn;
    }

    public String getEfterNavn() {
        return efterNavn;
    }

    public void setEfterNavn(String efterNavn) {
        this.efterNavn = efterNavn;
    }

    private String adresse;


    public int getCpr() {
        return cpr;
    }


    public DateTimeFormat getFødselsdato() {
        return fødselsdato;
    }

    public int getHøjde() {
        return højde;
    }

    public void setHøjde(int cm) {
        this.højde = cm;
    }

    public int getVægt() {
        return vægt;
    }

    public void setVægt(int vægt) {
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


}


