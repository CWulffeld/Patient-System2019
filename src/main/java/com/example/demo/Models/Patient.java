package com.example.demo.Models;

import com.example.demo.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

public class Patient {

    List<Patient> patientList;

    private String forNavn;
    private String efterNavn;
    @Id
    private int cpr;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String foedselsdato;
    private int hoejde;
    private int vaegt;
    private int telefonNr = 0;
    private String adresse;
    private String kortBeskrivelse;


    @Autowired
    PatientService patientService;

    public Patient(String forNavn, String efterNavn, int cpr, String foedselsdato, int telefonNr, String adresse, int hoejde, int vaegt, String kortBeskrivelse){

        this.forNavn=forNavn;
        this.efterNavn=efterNavn;
        this.cpr=cpr;
        this.foedselsdato = foedselsdato;
        this.telefonNr=telefonNr;
        this.adresse=adresse;
        this.hoejde = hoejde;
        this.vaegt = vaegt;
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

    public int getCpr() { return cpr; }

    public void setCpr(int cpr){
        if(cpr >= 1000 && cpr < 10000)
        {
            this.cpr=cpr;
        }
    }

    public String getFoedselsdato() {
        return foedselsdato;
    }

    public void setFoedselsdato(String foedselsdato) {
        this.foedselsdato = foedselsdato;
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

    public int getHoejde() {
        return hoejde;
    }

    public void setHoejde(int cm) {
        this.hoejde = cm;
    }

    public int getVaegt() {
        return vaegt;
    }

    public void setVaegt(int vaegt) {
        this.vaegt = vaegt;
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
                "\n , Fødselsdato = " + foedselsdato + '\'' +
                "\n , telefonNr = " + telefonNr + '\'' +
                "\n , adresse = " + adresse + '\'' +
                "\n , hoejde = " + hoejde + '\'' +
                "\n , vaegt = " + vaegt + '\'' +
                "\n , kortBeskrivelse = " + kortBeskrivelse;
    }
}


