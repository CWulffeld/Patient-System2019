package com.example.demo.Controllers;

import com.example.demo.Models.Bruger;
import com.example.demo.Models.Patient;
import com.example.demo.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class LoginController {


    @Autowired
    PatientService patientService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }


   //Virker ikke rigtigt endnu. Den tester for læge/sekretær, men ikke for cpr.Den ved dog godt den skal have en int som input.
    @PostMapping("/login")
    public String login(Patient patient, Model model, Bruger bruger) throws SQLException, ClassNotFoundException {
        Patient loggedIn;
       // patientService.tjekLogin(patient.getCpr());


        model.addAttribute("cpr", patientService.FindPatient(patient.getCpr()));


        if(patientService.tjekLogin(patient.getCpr())){
            if (bruger.getRolle().equalsIgnoreCase("Læge")){
                System.out.println(patient.getCpr());
                loggedIn = patientService.FindPatient(patient.getCpr());
                System.out.println(loggedIn.toString() + "ok");
                return "lægeHome";
            }
            else  if (bruger.getRolle().equalsIgnoreCase("Sekretær")){
                System.out.println(patient.getCpr());
                return "sekretærHome";
            }
        }
        return "login";

        //return "lægeHome";
    }
}
