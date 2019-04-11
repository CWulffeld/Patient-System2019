package com.example.demo.Controllers;


import com.example.demo.Models.Diagnose;
import com.example.demo.Models.Konsultation;
import com.example.demo.Models.Patient;
import com.example.demo.Services.DiagnoseService;
import com.example.demo.Services.KonsultationService;
import com.example.demo.Services.PatientService;
import com.example.demo.Services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LægeController {

    @Autowired
    PatientService patientService;

    @Autowired
    PatientServiceImpl patientServiceimpl;

    @Autowired
    DiagnoseService diagnoseService;

    @Autowired
    KonsultationService konsultationService;

    @GetMapping("/opretPatient")
    public String submitPatient(Model model){
        model.addAttribute("patient", new Patient());

        return "opretPatient";
    }

    @PostMapping("/opretPatient")
    public String submitPatient (@ModelAttribute Patient patient) throws SQLException, ClassNotFoundException {
        patientService.opretPatient(patient);
        return "opretPatient";
    }

    @GetMapping("/opretReceptLæge")
    public String opretRecept() {
        return "opretReceptLæge";
    }

    @GetMapping("/opretKonsultation")
    public String opretKonsultation(Model model) {
        model.addAttribute("konsultation", new Konsultation());

        return "opretKonsultation";
    }

    @PostMapping("/opretKonsultation")
    public String opretKonsultation(@ModelAttribute Konsultation konsultation, Model model) throws SQLException, ClassNotFoundException {
        System.out.println("step 1");
        konsultationService.opretKonsultation(konsultation);
        System.out.println("step 2");
        return "opretKonsultation";
    }



    @GetMapping("/tildelDiagnose")
    public String tildelDiagnose(Model model) {

        model.addAttribute("diagnose", new Diagnose());
        return "tildelDiagnose";
    }

    @PostMapping("/tildelDiagnose")
    public String tildelDiagnose(@ModelAttribute Diagnose diagnose, Model model) throws SQLException, ClassNotFoundException {

        diagnoseService.opretDiagnose(diagnose);
        return "tildelDiagnose";
    }

    @GetMapping("/patientInformationer")
    public String patientInformationer(Model model, Patient patient) throws SQLException, ClassNotFoundException {

        patientService.FindPatient(patient.getCpr());

        model.addAttribute("fornavn", patient.getForNavn());
        model.addAttribute("efternavn", patient.getEfterNavn());
        model.addAttribute("cpr", patient.getCpr());

        return "patientinformationer";
    }

    @GetMapping("/opdaterPatient")
    public String opdaterPatient(){
        return "opdaterPatient";
    }

    @GetMapping("/sletPatient")
    public String sletPatient(){
        return "sletPatient";
    }

}
