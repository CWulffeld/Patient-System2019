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


   //Virker ikke rigtigt endnu. Den tester for læge/sekretær, men ikke for cpr.Den ved godt dog godt den skal have en int som input.
    @PostMapping("/login")
    public String login(Patient patient, Model model, Bruger bruger) throws SQLException, ClassNotFoundException {

       // patientService.tjekLogin(patient.getCpr());


        if (bruger.getRolle().equalsIgnoreCase("Læge")){
            patientService.tjekLogin(patient.getCpr());
            System.out.println(patient.getCpr());
            return "lægeHome";
        }
        else  if (bruger.getRolle().equalsIgnoreCase("Sekretær")){
            System.out.println(patient.getCpr());
            patientService.tjekLogin(patient.getCpr());
            return "sekretærHome";
        }else {
            return "login";
        }
        //return "lægeHome";
    }
}
