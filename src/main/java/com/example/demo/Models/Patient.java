package com.example.demo.Models;

import com.example.demo.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Patient {

    List<Patient> patientList;

    private String forNavn;
    private String efterNavn;
    @Id
    private int cpr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fødselsdato;
    private int højde;
    private int vægt;
    private int telefonNr = 0;
    private String adresse;
    private String kortBeskrivelse;


    @Autowired
    PatientService patientService;

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


