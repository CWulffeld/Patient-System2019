package com.example.demo.Controllers;

import com.example.demo.Models.Bruger;
import com.example.demo.Models.Patient;
import com.example.demo.Services.PatientService;
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
public class LoginController {


    @Autowired
    PatientService patientService;

    /*@GetMapping("/login")
    public String login(Model model, Patient patient) throws SQLException, ClassNotFoundException {
        model.addAttribute("patient", patientService.FindPatient(patient.getCpr()));
        return "login";
    }

    //Virker ikke rigtigt endnu. Den tester for læge/sekretær, men ikke for cpr.Den ved dog godt den skal have en int som input.
    @PostMapping("/login")
    public String login(Patient patient, Model model, Bruger bruger) throws SQLException, ClassNotFoundException {
        // patientService.tjekLogin(patient.getCpr());

        // model.addAttribute("patient", patientService.FindPatient(patient.getCpr()));
        if(patientService.tjekLogin(patient.getCpr())){
            //patientService.FindPatient(patient.getCpr());
            if (bruger.getRolle().equalsIgnoreCase("Læge")){
                System.out.println(patient.getCpr());
                model.addAttribute("patient", patientService.FindPatient(patient.getCpr()));

                return "lægeHome";
            }
            else  if (bruger.getRolle().equalsIgnoreCase("Sekretær")){
                System.out.println(patient.getCpr());
                return "sekretærHome";
            }
        }
        model.addAttribute("error" , true);
        return "login";

        //return "lægeHome";
    }

    @ModelAttribute("patient")
    public Patient nuværendePatient(Patient patient)throws SQLException, ClassNotFoundException{
        Patient LoggedIn = patient;
        return LoggedIn;
    }*/
}
