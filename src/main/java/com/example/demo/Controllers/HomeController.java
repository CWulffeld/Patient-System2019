package com.example.demo.Controllers;


import com.example.demo.Models.Patient;
import com.example.demo.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.sql.SQLException;

@Controller
public class HomeController {


@Autowired
PatientService patientService;

    /*
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
    */

    @GetMapping("/")
    public String home() {

        return "home";
    }

    @GetMapping("/lægeHome")
    public String lægeHome(Model model, Patient patient) throws SQLException, ClassNotFoundException {
//            model.addAttribute("fornavn", patient.getForNavn());
//            model.addAttribute("efternavn", patient.getEfterNavn());
//            model.addAttribute("cpr", patient.getCpr());
        model.addAttribute("cpr", patientService.FindPatient(patient.getCpr()));
        return "lægeHome";
    }


    @GetMapping("/sekretærHome")
    public String sekretærHome() {
        return "sekretærHome";
    }


    @GetMapping("/lægeStartsside")
    public String lægeStartsside(){
        return "lægeStartsside";
    }


}
