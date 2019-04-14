package com.example.demo.Controllers;


import com.example.demo.Models.*;
import com.example.demo.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("patient")
public class LægeController {

    @Autowired
    PatientService patientService;

    @Autowired
    DiagnoseService diagnoseService;

    @Autowired
    KonsultationService konsultationService;

    ReceptServiceImpl receptService = new ReceptServiceImpl();

    @GetMapping("/lægeHome")
    public String lægeHome(){
        return "lægeHome";
    }

    @GetMapping("/opretPatient")
    public String submitPatient(Model model){
        model.addAttribute("patient", new Patient());

        return "opretPatient";
    }

    @PostMapping("/opretPatient")
    public String submitPatient (@ModelAttribute Patient patient) throws SQLException, ClassNotFoundException {
        patientService.opretPatient(patient);
        return "lægeHome";
    }

    @GetMapping("/opretReceptLæge")
    public String opretRecept(Model model) {
        model.addAttribute("recept", new Recept());
        return "opretReceptLæge";
    }

    @PostMapping("/opretReceptLæge")
    public String opretRecept(Recept recept, Patient patient) throws SQLException, ClassNotFoundException{
        recept.setCpr(patient.getCpr());
        recept.setPatientNavn(patient.getForNavn(), patient.getEfterNavn());
        receptService.opretRecept(recept);
        return "lægeHome";
    }

    @GetMapping("/opretKonsultation")
    public String opretKonsultation(Model model) {
        model.addAttribute("konsultation", new Konsultation());
        return "opretKonsultation";
    }

    @PostMapping("/opretKonsultation")
    public String opretKonsultation(Konsultation konsultation, Patient patient) throws SQLException, ClassNotFoundException {
        konsultation.setCpr(patient.getCpr());
        konsultation.setPatientNavn(patient.getForNavn(), patient.getEfterNavn());
        konsultationService.opretKonsultation(konsultation);
        return "lægeHome";
    }


    @GetMapping("/tildelDiagnose")
    public String tildelDiagnose(Model model) {
        model.addAttribute("diagnose", new Diagnose());
        return "tildelDiagnose";
    }

    @PostMapping("/tildelDiagnose")
    public String tildelDiagnose(Diagnose diagnose, Patient patient) throws SQLException, ClassNotFoundException {
        diagnose.setPatientNavn(patient.getForNavn(), patient.getEfterNavn());
        diagnose.setCpr(patient.getCpr());
        diagnoseService.opretDiagnose(diagnose);
        return "lægeHome";
    }

    @GetMapping("/patientInformationer")
    public String patientInformationer(@ModelAttribute Patient patient, Model model){
        model.addAttribute("fornavn", patient.getForNavn());
        model.addAttribute("efternavn", patient.getEfterNavn());
        model.addAttribute("cpr", patient.getCpr());
        return "patientinformationer";
    }

    @GetMapping("/opdaterPatient")
    public String opdaterPatient(){
        return "opdaterPatient";
    }

    @PostMapping("/opdaterPatient")
    public String opdaterPatient(@ModelAttribute Patient patient) throws SQLException, ClassNotFoundException {
        patientService.opdaterPatient(patient);
        return "lægeHome";
    }

    @GetMapping("/sletPatient")
    public String sletPatient(){
        return "sletPatient";
    }

    @PostMapping("/sletPatient")
    public String sletPatient(@ModelAttribute Patient patient)throws SQLException, ClassNotFoundException{
        patientService.sletPatient(patient.getCpr());
        return "lægeStartsside";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(Patient patient, Model model, Bruger bruger) throws SQLException, ClassNotFoundException {
        Patient login = patientService.findPatient(patient.getCpr());
        if(login.getCpr() != 0){
            if (bruger.getRolle().equalsIgnoreCase("Læge")){
                model.addAttribute("patient", login);
                return "lægeHome";
            }
            else  if (bruger.getRolle().equalsIgnoreCase("Sekretær")){
                return "sekretærHome";
            }
        }
        model.addAttribute("error" , true);
        return "login";
    }
}
