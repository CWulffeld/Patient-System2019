package com.example.demo.Controllers;


import com.example.demo.Models.Patient;
import com.example.demo.Services.PatientService;
import com.example.demo.Services.PatientServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LægeController {

    //PatientService patientService;
    PatientServiceImpl patientService;

    @GetMapping("/opretPatient")
    public String submitPatient(){
        return "opretPatient";
    }

    @PostMapping(value = "/opretPatient")
    public String opretPatient (Patient patient){

        patientService.opretPatient(patient);
        return "home";
    }

    @GetMapping("/opretReceptLæge")
    public String opretRecept() {
        return "opretReceptLæge";
    }

    @GetMapping("/opretKonsultation")
    public String opretKonsultation() {
        return "opretKonsultation";
    }


    @GetMapping("/tildelDiagnose")
    public String tildelDiagnose() {
        return "tildelDiagnose";
    }

    @GetMapping("/patientInformationer")
    public String patientInformationer(){
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
