//package com.example.demo.Models;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import java.util.Date;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.xml.bind.annotation.XmlRootElement;
//
//@Entity
//@XmlRootElement
//public class Patient {
//    @Id
//    private int cpr;
//    private String navn;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date alder;
//    private int højde;
//    private double vægt;
//    private int telefonNr;
//    private String adresse;
//
//    public Patient(int cpr, String navn, Date dato, int cm, double vægt, int telefonNr, String adresse) {
//        this.cpr = cpr;
//        this.navn = navn;
//        this.alder = dato;
//        this.højde = cm;
//        this.vægt = vægt;
//        this.telefonNr = telefonNr;
//        this.adresse = adresse;
//    }
//
//    public int getCpr() {
//        return cpr;
//    }
//
//    public String getNavn() {
//        return navn;
//    }
//
//    public void setNavn(String navn) {
//        this.navn = navn;
//    }
//
//    public Date getAlder() {
//        return alder;
//    }
//
//    public int getHøjde() {
//        return højde;
//    }
//
//    public void setHøjde(int cm) {
//        this.højde = cm;
//    }
//
//    public double getVægt() {
//        return vægt;
//    }
//
//    public void setVægt(double vægt) {
//        this.vægt = vægt;
//    }
//
//    public int getTelefonNr() {
//        return telefonNr;
//    }
//
//    public void setTelefonNr(int telefonNr) {
//        this.telefonNr = telefonNr;
//    }
//
//    public String getAdresse() {
//        return adresse;
//    }
//
//    public void setAdresse(String adresse) {
//        this.adresse = adresse;
//    }
//
//    @Override
//    public String toString() {
//        return "Patient{" +
//                "cpr=" + cpr +
//                ", navn='" + navn + '\'' +
//                ", alder=" + alder +
//                ", højde=" + højde +
//                ", vægt=" + vægt +
//                ", telefonNr=" + telefonNr +
//                ", Adresse='" + adresse + '\'' +
//                '}';
//    }
//
//    // private List<Patient> patientList;
//}
