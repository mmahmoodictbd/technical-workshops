package com.unloadbrain.covid19advices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class AdviceController {

    @GetMapping("/")
    public String showAdvicePage() {
        return "advices";
    }

    @GetMapping("/covid-19-symptoms")
    public String showSymptomsPage(Model model) {
        model.addAttribute("date", new Date());
        return "symptoms";
    }
}
