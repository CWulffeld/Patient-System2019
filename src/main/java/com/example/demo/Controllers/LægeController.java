package com.example.demo.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LægeController {

    @GetMapping("/opretPatient")
    public String opretPatient(){
        return "opretPatient";
    }

    @GetMapping("/opretReceptLæge")
    public String opretRecept() {
        return "opretReceptLæge";
    }

    @GetMapping("/opretKonsultation")
    public String opretKonsultation() {
        return "opretKonsultation";
    }


    @GetMapping("/opretDiagnose")
    public String opretDiagnose() {
        return "opretDiagnose";
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
