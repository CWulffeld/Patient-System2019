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
import java.util.List;

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
    public String home(Model model)throws SQLException, ClassNotFoundException {
        //List<Patient> patienter = patientService.findAllePatienter();
        //model.addAttribute("patienter", patienter);
        return "home";
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
