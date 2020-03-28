package com.unloadbrain.covid19bangladesh.controller;

import com.unloadbrain.covid19bangladesh.dto.Covid19CountryStat;
import com.unloadbrain.covid19bangladesh.service.Covid19DataScraperService;
import lombok.AllArgsConstructor;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class Covid19StatController {

    private final PrettyTime prettyTime = new PrettyTime(new Locale("en"));
    private final Covid19DataScraperService covid19DataScraperService;

    @GetMapping("/bangladesh")
    public String showCovid19BangladeshStat(Model model) {

        Covid19CountryStat stat = covid19DataScraperService.scrape();
        model.addAttribute("affected", stat.getTotalAffected());
        model.addAttribute("death", stat.getTotalDeath());
        model.addAttribute("recovered", stat.getTotalRecovered());
        model.addAttribute("lastUpdated", prettyTime.format(new Date(stat.getUnixTimestamp())));

        return "stat";
    }
}
