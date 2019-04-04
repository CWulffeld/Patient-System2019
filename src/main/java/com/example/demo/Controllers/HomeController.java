package com.example.demo.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(){

        return "home";
    }


    @GetMapping("/lægeHome")
    public String lægeHome(){
        return "lægeHome";
    }

    @GetMapping("/sekretærHome")
    public String sekretærHome(){
        return "sekretærHome";
    }
}
