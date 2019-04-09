package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Patient {

    private List<Patient> patientList;

    @Id

    private String forNavn;
    private String efterNavn;
    private int cpr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private DateTimeFormat fødselsdato;
    private int højde;
    private int vægt;
    private int telefonNr;
    private String adresse;
    private String kortBeskrivelse;

    public Patient(String forNavn, String efterNavn, int cpr, DateTimeFormat fødselsdato, int højde, int vægt, int telefonNr, String adresse, String kortBeskrivelse){

        this.forNavn=forNavn;
        this.efterNavn=efterNavn;
        this.cpr=cpr;
        this.fødselsdato=fødselsdato;
        this.højde=højde;
        this.vægt=vægt;
        this.telefonNr=telefonNr;
        this.adresse=adresse;
        this.kortBeskrivelse=kortBeskrivelse;
    }

    public Patient(){

    }

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

    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr){ this.cpr=cpr;}

    public DateTimeFormat getFødselsdato() {
        return fødselsdato;
    }

    public void setFødselsdato(DateTimeFormat fødselsdato) {
        this.fødselsdato = fødselsdato;
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

    public String getKortBeskrivelse() {
        return kortBeskrivelse;
    }

    public void setKortBeskrivelse(String kortBeskrivelse) {
        this.kortBeskrivelse = kortBeskrivelse;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "cpr=" + cpr +
                ", fornavn='" + forNavn + '\'' +
                ", efternavn='" + efterNavn + '\'' +
                ", fødselsdato='" + fødselsdato + '\'' +
                ", højde=" + højde + '\'' +
                ", vægt=" + vægt + '\'' +
                ", telefonNr=" + telefonNr + '\'' +
                ", adresse=" + adresse + '\'' +
                ", kortBeskrivelse=" + kortBeskrivelse +
                '}';
    }
}


