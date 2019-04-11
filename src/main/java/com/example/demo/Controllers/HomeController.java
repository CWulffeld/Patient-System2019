package com.example.demo.Controllers;


import com.example.demo.Models.Patient;
import com.example.demo.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class HomeController {



    @GetMapping("/")
    public String home() {

        return "home";
    }

    @GetMapping("/lægeHome")
    public String lægeHome() {

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
