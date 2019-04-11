package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Patient {

    private List<Patient> patientList;

    private String forNavn= "ingenting";
    private String efterNavn= "ingenting";
    @Id
    private int cpr=0;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fødselsdato = "ingenting";
    private int højde = 0;
    private int vægt= 0;
    private int telefonNr = 0;
    private String adresse ="ingenting";
    private String kortBeskrivelse="ingenting";

    public Patient(String forNavn, String efterNavn, int cpr, String fødselsdato, int telefonNr, String adresse, int højde, int vægt, String kortBeskrivelse){

        this.forNavn=forNavn;
        this.efterNavn=efterNavn;
        this.cpr=cpr;
        this.fødselsdato=fødselsdato;
        this.telefonNr=telefonNr;
        this.adresse=adresse;
        this.højde=højde;
        this.vægt=vægt;
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

    public String getFødselsdato() {
        return fødselsdato;
    }

    public void setFødselsdato(String fødselsdato) {
        this.fødselsdato = fødselsdato;
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

    public String getKortBeskrivelse() {
        return kortBeskrivelse;
    }

    public void setKortBeskrivelse(String kortBeskrivelse) {
        this.kortBeskrivelse = kortBeskrivelse;
    }

    @Override
    public String toString() {
        return "patient: \n" +
                "Fornavn = " + forNavn + '\'' +
                "\n , Efternavn = " + efterNavn + '\'' +
                "\n , Cpr = " + cpr + '\'' +
                "\n , Fødselsdato = " + fødselsdato + '\'' +
                "\n , telefonNr = " + telefonNr + '\'' +
                "\n , adresse = " + adresse + '\'' +
                "\n , højde = " + højde + '\'' +
                "\n , vægt = " + vægt + '\'' +
                "\n , kortBeskrivelse = " + kortBeskrivelse;
    }
}


